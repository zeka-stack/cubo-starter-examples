---
published: 2022.05.23
---

# 启动器示例（Thin 模式）

展示 `cubo-launcher-spring-boot` 的轻量启动模式，包含配置占位符解析和多环境配置管理。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 说明 |
|------|------|
| 配置占位符 | 支持 `${placeholder}` 和 `@placeholder@` 两种语法 |
| 多环境配置 | `application-local.yml` / `application-dev.yml` 按 Profile 切换 |
| 配置测试 | 包含完整的配置占位符解析单元测试 |

## 测试验证

```bash
mvn test
```

## 相关链接

- [[cubo-starter/cubo-launcher-spring-boot/index|应用启动器]]

