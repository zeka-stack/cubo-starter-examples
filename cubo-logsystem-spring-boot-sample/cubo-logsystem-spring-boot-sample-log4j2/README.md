---
published: 2022.05.23
---

# 日志系统示例（Log4j2）

基于 Log4j2 的日志体系示例，展示 `cubo-logsystem-log4j2-spring-boot-starter` 的结构化日志和动态日志管理能力。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| 动态日志级别 | `ChangeLogLevelTest` | 运行时修改日志级别，无需重启 |
| 日志格式切换 | `ChangeLogSystemPatternTest` | 动态切换日志输出格式 |
| 日志文件名变更 | `ChangeLogFileNameTest` | 动态修改日志文件名 |
| 日志配置变更 | `ChangeLogConfigTest` | 运行时更新完整日志配置 |
| 显示调用位置 | `ChangeEnableShowLocationTest` | 开启/关闭日志中的代码位置信息 |

## 测试验证

```bash
mvn test
```

## 相关链接

- [[cubo-starter/cubo-logsystem-spring-boot/index|日志系统]]

