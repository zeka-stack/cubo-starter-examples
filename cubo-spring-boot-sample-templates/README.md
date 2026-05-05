# 示例工程模板

基于 Go 语言的示例工程脚手架生成器，用于批量创建结构一致的 Cubo Starter 示例工程。

## 用途

当需要新增一个 Starter 示例时，使用此模板快速生成标准化目录结构，避免手动创建带来的格式不一致问题。

## 使用方式

```bash
# 查看模板结构
ls cubo-{{name}}-spring-boot-sample/

# 使用 create.go 脚手架工具生成新示例
go run create.go
```

## 生成的目录结构

```
cubo-xxx-spring-boot-sample/
├── pom.xml
├── src/
│   ├── main/java/...
│   └── test/java/...
└── README.md
```

## 相关链接

- [[cubo-starter/cubo-combiner-spring-boot/index|组合 Starter]]
- [[cubo-starter/cubo-spring-boot-templates/index|Spring Boot 模板]]
