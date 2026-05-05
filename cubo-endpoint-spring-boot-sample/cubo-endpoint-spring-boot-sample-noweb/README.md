---
published: 2022.05.23
---

# 运维端点示例（非 Web）

非 Web 环境下的运维端点示例，展示 `cubo-endpoint-spring-boot-autoconfigure` 在无 Web 服务场景（如定时任务、消息消费）中的健康检查能力。

## 运行方式

```bash
mvn test
```

## 演示特性

- 不依赖 Web 容器的健康检查
- 非 Web 应用的指标采集
- 适合定时任务、消息消费者等无 HTTP 端口的应用

## 相关链接

- [[cubo-starter/cubo-endpoint-spring-boot/index|运维端点]]

