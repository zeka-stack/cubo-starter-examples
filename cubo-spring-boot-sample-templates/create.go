package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"path/filepath"
	"strings"
	"time"
	"unicode"
	"regexp"
)

const (
	templateRoot = "cubo-spring-boot-sample-templates"
	outputRoot   = "."
	pomFile = "pom.xml"
    marker  = "<!--mark-->"
)

type TemplateData struct {
	Name         string
	UpperName    string
	Date         string
	Description  string
	Modules      []string
	UpperModules []string
}

func main() {
	printBanner()
	reader := bufio.NewReader(os.Stdin)

	// 获取 sample 名称
	fmt.Print("> 请输入 sample 名称 (如 launcher): ")
	nameInput, _ := reader.ReadString('\n')
	nameInput = strings.TrimSpace(nameInput)
	if nameInput == "" {
		printError("sample 名称不能为空")
		log.Fatal("请提供有效的 sample 名称")
	}

	// 获取描述
	fmt.Print("> 请输入 sample 描述: ")
	descriptionInput, _ := reader.ReadString('\n')
	descriptionInput = strings.TrimSpace(descriptionInput)
	if descriptionInput == "" {
		printWarning("描述为空，将使用默认描述")
		descriptionInput = fmt.Sprintf("Cubo %s sample", nameInput)
	}

	// 获取子模块（多行输入，空行结束）
	fmt.Println("> 请输入子模块名称（每行一个，回车继续，空行结束）:")
	modules := []string{}
	for {
		fmt.Print("> ")
		moduleInput, _ := reader.ReadString('\n')
		moduleInput = strings.TrimSpace(moduleInput)
		if moduleInput == "" {
			break
		}
		if strings.Contains(moduleInput, " ") {
			printWarning("子模块名称不能包含空格，已自动去除")
			moduleInput = strings.ReplaceAll(moduleInput, " ", "")
		}
		if moduleInput == "" {
			continue
		}
		// 去重
		exists := false
		for _, m := range modules {
			if m == moduleInput {
				exists = true
				break
			}
		}
		if !exists {
			modules = append(modules, moduleInput)
		}
	}
	if len(modules) == 0 {
		printError("子模块名称不能为空")
		log.Fatal("请至少输入一个子模块名称")
	}
	printInfo(fmt.Sprintf("已输入子模块: %s", strings.Join(modules, ", ")))

	// 初始化模板数据
	upperModules := make([]string, len(modules))
	for i, module := range modules {
		upperModules[i] = uppercaseFirst(module)
	}
	data := TemplateData{
		Name:         nameInput,
		UpperName:    uppercaseFirst(nameInput),
		Date:         time.Now().Format("2006.01.02 15:04"),
		Description:  descriptionInput,
		Modules:      modules,
		UpperModules: upperModules,
	}

	// 构建路径
	templateDir := filepath.Join(templateRoot, fmt.Sprintf("cubo-{{name}}-spring-boot-sample"))
	rawTemplateDir := templateDir
	moduleDirName := fmt.Sprintf("cubo-%s-spring-boot-sample", data.Name)
	outputDir := filepath.Join(outputRoot, moduleDirName)

	printStatus("准备创建目录结构")
	if _, err := os.Stat(rawTemplateDir); os.IsNotExist(err) {
		printError(fmt.Sprintf("模板目录不存在: %s", rawTemplateDir))
		log.Fatalf("请检查模板路径是否正确")
	} else {
		printInfo(fmt.Sprintf("找到模板目录: %s", rawTemplateDir))
	}

	if err := os.MkdirAll(outputDir, 0755); err != nil {
		printError(fmt.Sprintf("无法创建目录 %s: %v", outputDir, err))
		log.Fatal("请检查文件系统权限")
	} else {
		printSuccess(fmt.Sprintf("创建目录成功: %s", outputDir))
	}

	printStatus("渲染模板文件")
	fileCount := 0
	dirCount := 0

	err := filepath.Walk(rawTemplateDir, func(path string, fileInfo os.FileInfo, err error) error {
		if err != nil {
			return err
		}
		relPath, _ := filepath.Rel(rawTemplateDir, path)
		if isIgnoredFile(relPath) {
			return nil
		}
		// 多模块特殊处理
		if strings.Contains(relPath, "{{module}}") || strings.Contains(relPath, "{{module...}}") {
			for _, module := range data.Modules {
				moduleData := data
				moduleData.Modules = []string{module}
				moduleData.UpperModules = []string{uppercaseFirst(module)}
				targetPath := filepath.Join(outputDir, replacePlaceholders(relPath, moduleData))
				if fileInfo.IsDir() {
					if err := os.MkdirAll(targetPath, 0755); err != nil {
						return err
					}
					dirCount++
					printInfo(fmt.Sprintf("创建目录: %s", targetPath))
					continue
				}
				contentBytes, err := os.ReadFile(path)
				if err != nil {
					return err
				}
				renderedContent := replacePlaceholders(string(contentBytes), moduleData)
				if err := os.WriteFile(targetPath, []byte(renderedContent), fileInfo.Mode()); err != nil {
					return err
				}
				fileCount++
				printInfo(fmt.Sprintf("创建文件: %s", targetPath))
			}
			return nil
		}
		// 普通文件/目录
		targetPath := filepath.Join(outputDir, replacePlaceholders(relPath, data))
		if fileInfo.IsDir() {
			if err := os.MkdirAll(targetPath, 0755); err != nil {
				return err
			}
			dirCount++
			printInfo(fmt.Sprintf("创建目录: %s", targetPath))
			return nil
		}
		contentBytes, err := os.ReadFile(path)
		if err != nil {
			return err
		}
		renderedContent := string(contentBytes)
		if strings.HasSuffix(path, "pom.xml") {
			renderedContent = processModulesTag(renderedContent, data)
			renderedContent = replacePlaceholders(renderedContent, data)
		} else {
			renderedContent = replacePlaceholders(renderedContent, data)
		}
		if err := os.WriteFile(targetPath, []byte(renderedContent), fileInfo.Mode()); err != nil {
			return err
		}
		fileCount++
		printInfo(fmt.Sprintf("创建文件: %s", targetPath))
		return nil
	})

	if err != nil {
		printError(fmt.Sprintf("模板渲染失败: %v", err))
		log.Fatal("请检查模板文件是否有效")
	}

	printInfo("更新 cubo-starter-examples/pom.xml ...")
	if err := insertSampleModule(data.Name); err != nil {
		printWarning(fmt.Sprintf("添加 sample 模块失败: %v", err))
	} else {
		printSuccess("sample 模块添加成功")
	}

	printSuccess(fmt.Sprintf("渲染完成! 创建了 %d 个目录和 %d 个文件", dirCount, fileCount))
	printStatus("完成 🎉🎉🎉")
	fmt.Println("\n" + successBox("🎉 sample 示例模块创建成功！"))
	fmt.Println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓")
	fmt.Printf("  🏷️  sample名称:   %-34s         \n", data.Name)
	fmt.Printf("  📁  sample目录:   %-34s         \n", outputDir)
	fmt.Printf("  🔧  子模块:     %-34s           \n", strings.Join(data.Modules, ", "))
	fmt.Printf("  🕒  创建时间:   %-34s           \n", time.Now().Format("2006-01-02 15:04:05"))
	fmt.Println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛")
	fmt.Println("\n💡 祝您开发顺利！✨\n")
}

// 工具函数
func printBanner() {
	fmt.Println()
	fmt.Println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓")
	fmt.Println("┃         Cubo Sample 示例生成工具 v1.0         ┃")
	fmt.Println("┃     自动化创建 Spring Boot Sample 示例        ┃")
	fmt.Println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛")
	fmt.Println()
}
func printStatus(message string)   { fmt.Printf("\n🎉 %s\n", message) }
func printInfo(message string)     { fmt.Printf("   📍 %s\n", message) }
func printSuccess(message string)  { fmt.Printf("   ✅ %s\n", message) }
func printWarning(message string)  { fmt.Printf("   ❗ %s\n", message) }
func printError(message string)    { fmt.Printf("   ✗ %s\n", message) }
func successBox(message string) string {
	return "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
		fmt.Sprintf("  %-46s  \n", message) +
		"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"
}
func isIgnoredFile(path string) bool {
	if strings.Contains(path, ".DS_Store") ||
		strings.Contains(path, "Icon\r") ||
		strings.HasSuffix(path, "~") {
		return true
	}
	base := filepath.Base(path)
	if strings.HasPrefix(base, ".") && base != ".gitkeep" {
		return true
	}
	return false
}
func uppercaseFirst(s string) string {
	if s == "" {
		return ""
	}
	r := []rune(s)
	r[0] = unicode.ToUpper(r[0])
	return string(r)
}
func replacePlaceholders(input string, data TemplateData) string {
	result := strings.ReplaceAll(input, "{{name}}", data.Name)
	result = strings.ReplaceAll(result, "{{Name}}", data.UpperName)
	result = strings.ReplaceAll(result, "{{date}}", data.Date)
	result = strings.ReplaceAll(result, "{{description}}", data.Description)
	// 支持 {{module}} 和 {{module...}}
	if strings.Contains(result, "{{module}}") || strings.Contains(result, "{{module...}}") {
		if len(data.Modules) > 0 {
			result = strings.ReplaceAll(result, "{{module}}", data.Modules[0])
			result = strings.ReplaceAll(result, "{{module...}}", data.Modules[0])
		}
	}
	if strings.Contains(result, "{{Module}}") || strings.Contains(result, "{{Module...}}") {
		if len(data.UpperModules) > 0 {
			result = strings.ReplaceAll(result, "{{Module}}", data.UpperModules[0])
			result = strings.ReplaceAll(result, "{{Module...}}", data.UpperModules[0])
		}
	}
	return result
}

func processModulesTag(content string, data TemplateData) string {
    modulesRegex := regexp.MustCompile(`<modules>\s*((?:<module>[^<]+</module>\s*)*)</modules>`)
    return modulesRegex.ReplaceAllStringFunc(content, func(match string) string {
        moduleRegex := regexp.MustCompile(`<module>([^<]+)</module>`)
        matches := moduleRegex.FindAllStringSubmatch(match, -1)
        var modules []string
        for _, m := range matches {
            moduleName := m[1]
            if strings.Contains(moduleName, "{{module...}}") {
                for _, module := range data.Modules {
                    actualModule := strings.ReplaceAll(moduleName, "{{module...}}", module)
                    modules = append(modules, actualModule)
                }
            } else {
                modules = append(modules, moduleName)
            }
        }
        var moduleTags []string
        for _, module := range modules {
            moduleTags = append(moduleTags, fmt.Sprintf("        <module>%s</module>", module))
        }
        return fmt.Sprintf("    <modules>\n%s\n    </modules>", strings.Join(moduleTags, "\n"))
    })
}

// 在 pom.xml 的 <!--mark--> 后插入新模块
func insertSampleModule(moduleName string) error {
    filePath := filepath.Join(".", pomFile)
    fileContent, err := os.ReadFile(filePath)
    if err != nil {
        return err
    }
    contentStr := string(fileContent)
    idx := strings.Index(contentStr, marker)
    if idx == -1 {
        return fmt.Errorf("标记 %s 未找到，请在 pom.xml 中添加该标记", marker)
    }
    insertPos := idx + len(marker)
    mod := fmt.Sprintf("\n        <module>cubo-%s-spring-boot-sample</module>", moduleName)
    // 防止重复添加
    if strings.Contains(contentStr[insertPos:], fmt.Sprintf("cubo-%s-spring-boot-sample", moduleName)) {
        printInfo(fmt.Sprintf("已在 pom.xml 中找到模块，跳过添加"))
        return nil
    }
    newContent := contentStr[:insertPos] + mod + contentStr[insertPos:]
    return os.WriteFile(filePath, []byte(newContent), 0644)
}
