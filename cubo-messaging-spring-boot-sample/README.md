---
published: 2022.05.23
---

# 消息处理示例

## 概述

本示例项目展示了如何使用 `cubo-messaging-spring-boot` 组件进行消息队列处理，支持 Kafka 和 RocketMQ 两种消息中间件。

## 子模块说明

### 1. cubo-messaging-spring-boot-sample-kafka

**Kafka 示例**，展示了：

- Kafka 消息发送和接收
- 消息事务处理
- 消费者组配置
- 消息序列化配置

### 2. cubo-messaging-spring-boot-sample-rocketmq

**RocketMQ 示例**，展示了：

- RocketMQ 消息发送和接收
- 顺序消息处理
- 延迟消息发送
- 事务消息处理

### 3. cubo-messaging-spring-boot-sample-all

**混合示例**，展示了：

- 同时使用 Kafka 和 RocketMQ
- 不同消息中间件的统一抽象

## 快速开始

### 运行 Kafka 示例

```bash
# 启动 Kafka
docker-compose up -d kafka

# 运行示例
cd cubo-messaging-spring-boot-sample-kafka
mvn spring-boot:run
```

### 运行 RocketMQ 示例

```bash
# 启动 RocketMQ
docker-compose up -d rocketmq

# 运行示例
cd cubo-messaging-spring-boot-sample-rocketmq
mvn spring-boot:run
```

## 高阶用法

### 1. Kafka 消息发送

```java
@Service
public class MessageService {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
```

### 2. Kafka 消息接收

```java
@KafkaListener(topics = "test-topic", groupId = "test-group")
public void receiveMessage(String message) {
    log.info("收到消息: {}", message);
}
```

### 3. RocketMQ 消息发送

```java
@Service
public class RocketMQService {
    
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    
    public void sendMessage(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
    }
}
```

### 4. RocketMQ 消息接收

```java
@RocketMQMessageListener(
    topic = "test-topic",
    consumerGroup = "test-group"
)
public class MessageListener implements RocketMQListener<String> {
    
    @Override
    public void onMessage(String message) {
        log.info("收到消息: {}", message);
    }
}
```

### 5. 事务消息

```java
@Transactional
public void sendTransactionMessage(String topic, String message) {
    // 业务逻辑
    rocketMQTemplate.sendMessageInTransaction(
        topic, 
        MessageBuilder.withPayload(message).build(),
        null
    );
}
```

### 6. 顺序消息

```java
public void sendOrderedMessage(String topic, String message, String orderKey) {
    rocketMQTemplate.syncSendOrderly(
        topic,
        message,
        orderKey
    );
}
```

### 7. 延迟消息

```java
public void sendDelayedMessage(String topic, String message, int delayLevel) {
    Message<String> msg = MessageBuilder
        .withPayload(message)
        .setHeader(RocketMQHeaders.DELAY, delayLevel)
        .build();
    rocketMQTemplate.send(topic, msg);
}
```

### 8. 消息配置

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      group-id: test-group
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer

rocketmq:
  name-server: localhost:9876
  producer:
    group: test-producer-group
```

## 相关链接

- [[cubo-starter/cubo-messaging-spring-boot|消息处理]]
