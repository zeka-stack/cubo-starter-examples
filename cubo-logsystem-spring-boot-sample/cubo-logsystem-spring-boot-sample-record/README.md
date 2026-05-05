---
published: 2022.05.23
---

# 日志系统示例（Record）

日志记录存储示例，展示 `cubo-logsystem-record-spring-boot-starter` 将日志持久化到数据库的能力。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| 系统日志存储 | `SystemLogStorageService` | 系统操作日志写入数据库 |
| API 日志存储 | `ApiLogStorageService` | HTTP 请求/响应日志写入数据库 |
| 错误日志存储 | `ErrorLogStorageService` | 异常错误日志写入数据库 |
| 日志配置 | `LoggingConfiguration` | 日志存储的自定义配置 |

## 相关链接

- [[cubo-starter/cubo-logsystem-spring-boot/index|日志系统]]

