---
published: 2022.05.23
---

# 多租户示例（字段隔离）

基于字段（列）隔离的多租户方案示例，通过在 SQL 中自动追加租户字段实现数据隔离。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| 租户处理器 | `MyTenantHandler` | 自动在 SQL 中追加租户字段条件 |
| 租户上下文 | `MyContext` | 维护当前请求的租户标识 |
| MyBatis-Plus 配置 | `MybatisPlusConfig` | 多租户拦截器的注册与配置 |
| 实体类 | `User` | 包含 `tenantId` 字段的实体定义 |

## 相关链接

- [[cubo-starter/cubo-mybatis-spring-boot/index|数据访问层]]
Mybatis-Plus 通过 tenant_id 实现多租户
