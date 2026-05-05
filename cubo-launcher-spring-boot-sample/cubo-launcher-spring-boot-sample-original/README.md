---
published: 2022.05.23
---

# 启动器示例（原始模式）

使用原生 `spring-boot-starter-parent` 作为父 POM 的基础示例，展示不依赖 Zeka Stack 启动器时的标准 Spring Boot 项目结构。

用于与 `patch` 和 `thin` 模式对比，体现 `cubo-launcher-spring-boot` 的额外能力。

## 运行方式

```bash
mvn spring-boot:run
```

## 说明

此示例直接继承 `spring-boot-starter-parent`，不使用 `cubo-launcher-spring-boot-starter`，适合作为对照基准。

## 相关链接

- [[cubo-starter/cubo-launcher-spring-boot/index|应用启动器]]

