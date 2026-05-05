---
published: 2022.05.23
---

# 消息中间件示例（Kafka）

基于 Kafka 的消息处理示例，展示 `cubo-messaging-kafka-spring-boot-starter` 的消息发送和消费能力。

## 运行方式

需要先启动 Kafka 服务，然后运行示例：

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| Kafka 模板发送 | `KafkaTemplateTest` | 使用 `KafkaTemplate` 发送消息 |
| 消息模板 | `MessageTemplateTest` | 统一消息模板的使用方式 |
| 业务对象 | `Order` / `Payment` | 业务领域对象作为消息体的序列化方式 |

## 相关链接

- [[cubo-starter/cubo-messaging-spring-boot/index|消息处理]]

