---
published: 2022.05.23
---

# 消息中间件示例（多通道混合）

同时集成 Kafka 和 RocketMQ 的示例，展示 `cubo-messaging-spring-boot` 在多消息中间件共存场景下的统一抽象能力。

## 运行方式

需要同时启动 Kafka 和 RocketMQ 服务，然后运行示例：

```bash
mvn spring-boot:run
```

## 演示特性

- 多消息中间件同时接入
- 统一消息发送接口
- 不同中间件的通道隔离和路由

## 相关链接

- [[cubo-starter/cubo-messaging-spring-boot/index|消息处理]]

