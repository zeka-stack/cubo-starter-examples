---
published: 2022.05.23
---

# 多租户示例

展示 `cubo-mybatis-spring-boot-starter` 的三种多租户数据隔离方案。

## 子模块说明

| 子模块 | 隔离方式 | 说明 |
|--------|---------|------|
| cubo-mybatis-spring-boot-sample-tenant-field | 字段隔离 | SQL 中自动追加租户字段条件 |
| cubo-mybatis-spring-boot-sample-tenant-table | 表隔离 | SQL 中动态替换表名 |
| cubo-mybatis-spring-boot-sample-tenant-table-by-sharding | 分片路由 | 自定义分片算法按租户路由 |

## 相关链接

- [[cubo-starter/cubo-mybatis-spring-boot/index|数据访问层]]

