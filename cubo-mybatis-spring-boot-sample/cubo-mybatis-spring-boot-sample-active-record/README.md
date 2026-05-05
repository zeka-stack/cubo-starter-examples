---
published: 2022.05.23
---

# MyBatis 示例（Active Record）

Active Record 模式的数据访问示例，展示实体类直接继承 BaseMapper 实现 CRUD，适合简单业务场景。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| Active Record | `User` | 实体类直接拥有 CRUD 方法 |
| DAO 层 | `UserDao` | 基于 BaseMapper 的简洁数据访问 |
| 单元测试 | `SampleMybatisApplicationTest` | 完整的 CRUD 操作测试 |

## 相关链接

- [[cubo-starter/cubo-mybatis-spring-boot/index|数据访问层]]

