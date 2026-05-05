---
published: 2022.05.23
---

# 多租户示例（分片路由）

基于自定义分片算法的多租户表路由方案，通过 `ShardingAlgorithm` 实现按租户标识自动路由到对应表。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| 分片算法 | `OrderShardingAlgorithm` | 自定义分片键实现按租户路由 |
| 实体类 | `Order` | 订单实体，包含分片键字段 |
| DAO 层 | `OrderDao` | 订单数据访问，自动路由到租户对应表 |
| 单元测试 | `SampleShardingApplicationTest` | 验证分片路由的正确性 |

## 相关链接

- [[cubo-starter/cubo-mybatis-spring-boot/index|数据访问层]]使用 sharding-jdbc 分表
