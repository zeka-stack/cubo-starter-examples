---
published: 2022.05.23
---

# MyBatis 示例（单库）

单数据源的 MyBatis 数据访问示例，展示 `cubo-mybatis-spring-boot-starter` 的基础 ORM 能力。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 说明 |
|------|------|
| 单数据源配置 | 默认 H2 内存数据库，开箱即用 |
| 实体类映射 | `User` 实体与数据库表的映射 |
| DAO 层 | `UserDao` 使用 MyBatis-Plus 的 CRUD 能力 |
| DTO 转换 | `UserDTO` / `UserWrapper` 数据转换示例 |

## 相关链接

- [[cubo-starter/cubo-mybatis-spring-boot/index|数据访问层]]

