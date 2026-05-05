# Cubo Starter 示例工程

Cubo Starter 的配套示例工程集合，展示各 Starter 组件的使用方式和最佳实践。

## 示例列表

| 示例 | 说明 | 运行方式 |
|------|------|---------|
| cubo-rest-spring-boot-sample | REST API 规范示例 | Servlet / Reactive 两种模式 |
| cubo-logsystem-spring-boot-sample | 日志体系示例 | Log4j2 / Record / SLF4J 三种模式 |
| cubo-mybatis-spring-boot-sample | 数据访问层示例 | 单库 / 多库 / Active Record / 多租户 |
| cubo-openapi-spring-boot-sample | API 文档示例 | Knife4j / Dubbo 两种模式 |
| cubo-messaging-spring-boot-sample | 消息中间件示例 | Kafka / RocketMQ / 多通道混合 |
| cubo-endpoint-spring-boot-sample | 运维端点示例 | Servlet / Reactive / 非 Web 三种模式 |
| cubo-launcher-spring-boot-sample | 应用启动器示例 | 原始 / Patch / Thin 三种模式 |

## 快速运行

```bash
# 构建整个示例工程
./mvnw clean install -DskipTests

# 运行某个示例（以 REST Servlet 为例）
cd cubo-rest-spring-boot-sample/cubo-rest-spring-boot-sample-servlet
../../mvnw spring-boot:run
```

## 建议阅读顺序

1. 先从 `cubo-rest-spring-boot-sample` 入手，了解统一异常、响应和参数校验
2. 再看 `cubo-logsystem-spring-boot-sample`，了解日志规范
3. 按需查看其他示例
