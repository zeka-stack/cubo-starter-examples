---
published: 2022.05.23
---

# 运维端点示例（Servlet）

基于 Spring MVC 的运维端点示例，展示 `cubo-endpoint-servlet-spring-boot-starter` 在 Servlet 环境下的健康检查和指标暴露能力。

## 运行方式

```bash
mvn spring-boot:run
```

启动后访问端点页面：http://localhost:8080/actuator

## 演示特性

| 特性 | 说明 |
|------|------|
| 健康检查端点 | 应用健康状态自动检测和报告 |
| 指标暴露 | JVM、HTTP、自定义指标的采集与暴露 |
| 管理端点 | 应用运行时管理操作 |

## 相关链接

- [[cubo-starter/cubo-endpoint-spring-boot/index|运维端点]]

