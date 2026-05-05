---
published: 2022.05.23
---

# 多租户示例（表隔离）

基于表（行）隔离的多租户方案示例，通过在 SQL 中动态替换表名实现不同租户的数据隔离。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| 租户处理器 | `MyTenantHandler` | 根据租户标识动态替换 SQL 中的表名 |
| 租户上下文 | `MyContext` | 维护当前请求的租户标识 |
| MyBatis-Plus 配置 | `MybatisPlusConfig` | 表级多租户拦截器的注册与配置 |
| Mapper 层 | `UserMapper` | 按租户自动路由到对应表 |

## 相关链接

- [[cubo-starter/cubo-mybatis-spring-boot/index|数据访问层]]Mybatis-Plus 实现分表
