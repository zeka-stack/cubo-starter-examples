---
published: 2022.05.23
---

# MyBatis 示例（集成测试）

综合集成测试示例，展示 `cubo-ssm-spring-boot-starter` 的完整数据访问能力，包含代码生成、MapStruct 转换、P6Spy 监控等。

## 运行方式

```bash
mvn test
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| 基础 CRUD | `MybatisApplicationTest` | 标准增删改查操作 |
| 代码生成 | `AutoGeneratorCodeTest` | 自动生成 Entity / Mapper / Service |
| MapStruct 转换 | `UserMapstructWrapperTest` | 对象映射和转换 |
| SQL 日志 | `MybatisSqlLogTest` | SQL 语句日志输出 |
| P6Spy 监控 | `P6spyServiceTest` | P6Spy SQL 监控集成 |
| Service 层 | `UserServiceTest` | Service 层的完整测试 |
| DAO 层 | `UserDaoTest` | Mapper 层的数据访问测试 |

## 相关链接

- [[cubo-starter/cubo-mybatis-spring-boot/index|数据访问层]]

