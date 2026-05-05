---
published: 2022.05.23
---

# 日志系统示例

## 概述

本示例项目展示了如何使用 `cubo-logsystem-spring-boot` 组件进行日志管理，支持 Log4j2、SLF4J 和 Record 日志等多种日志框架。

## 子模块说明

### 1. cubo-logsystem-spring-boot-sample-log4j2

**Log4j2 示例**，展示了：

- Log4j2 配置和使用
- 异步日志配置
- 日志级别动态刷新
- 日志文件滚动策略

### 2. cubo-logsystem-spring-boot-sample-slf4j

**SLF4J 示例**，展示了：

- SLF4J 标准日志接口使用
- 日志级别配置
- 日志格式自定义

### 3. cubo-logsystem-spring-boot-sample-record

**Record 日志示例**，展示了：

- Java 14+ Record 类型的日志记录
- 结构化日志输出

## 快速开始

### 运行 Log4j2 示例

```bash
cd cubo-logsystem-spring-boot-sample-log4j2
mvn spring-boot:run
```

### 运行 SLF4J 示例

```bash
cd cubo-logsystem-spring-boot-sample-slf4j
mvn spring-boot:run
```

## 高阶用法

### 1. 日志级别动态刷新

```yaml
cubo:
  logsystem:
    refresh:
      enabled: true
      interval: 5000
```

通过配置中心或管理接口动态修改日志级别，无需重启应用。

### 2. 异步日志配置

```yaml
cubo:
  logsystem:
    async:
      enabled: true
      queue-size: 1024
      discard-threshold: INFO
```

### 3. 日志文件配置

```yaml
logging:
  file:
    name: logs/application.log
    max-size: 10MB
    max-history: 30
  pattern:
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
```

### 4. 日志级别配置

```yaml
logging:
  level:
    root: INFO
    dev.dong4j: DEBUG
    org.springframework: WARN
```

### 5. 结构化日志

```java
@Slf4j
public class UserService {
    
    public void createUser(User user) {
        log.info("创建用户: userId={}, userName={}", 
            user.getId(), user.getName());
    }
}
```

### 6. 日志记录器

```java
@Component
public class OperationLogger {
    
    @LogRecord(
        success = "用户 {#user.name} 创建成功",
        fail = "用户创建失败: {#_errorMsg}"
    )
    public void createUser(User user) {
        // 业务逻辑
    }
}
```

### 7. 日志监控

```yaml
management:
  endpoint:
    loggers:
      enabled: true
```

通过 `/actuator/loggers` 端点查看和修改日志级别。

## 相关链接

- [[cubo-starter/cubo-logsystem-spring-boot/index|日志系统]]
