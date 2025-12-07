---
published: 2022.05.23
---

# 应用启动器示例

## 概述

本示例项目展示了如何使用 `cubo-launcher-spring-boot` 组件进行应用启动和生命周期管理，包含三种不同的启动方式。

## 子模块说明

### 1. cubo-launcher-spring-boot-sample-thin

**瘦包启动示例**，展示了：

- **生命周期钩子**：`before()` 和 `after()` 方法在启动前后的处理
- **自定义事件**：`publishEvent()` 方法发送启动完成事件
- **配置热更新**：非 Spring Cloud 环境下的配置动态刷新
- **启动脚本**：提供了完整的应用启动、停止、重启脚本

#### 核心功能

- 启动前处理：在应用启动前执行初始化逻辑
- 启动后处理：在应用启动完成后执行业务逻辑
- 事件发布：启动完成后自动发布自定义事件
- 配置刷新：支持运行时动态刷新配置

### 2. cubo-launcher-spring-boot-sample-original

**原始启动方式**，展示了：

- 标准的 Spring Boot 应用启动方式
- 用于调试和对比不同启动方式的差异

### 3. cubo-launcher-spring-boot-sample-patch

**补丁包启动示例**，展示了：

- 补丁包部署方式
- 增量更新应用功能

## 快速开始

### 运行 Thin 示例

```bash
cd cubo-launcher-spring-boot-sample-thin
mvn clean package
./bin/launcher -s dev
```

### 启动脚本使用

```bash
# 启动应用（默认环境）
./bin/launcher

# 指定环境启动
./bin/launcher -s test

# 重启应用
./bin/launcher -r prod

# 停止应用
./bin/launcher -S prod

# 查看应用状态
./bin/launcher -c prod

# 启动并查看日志
./bin/launcher -s dev -t
```

## 高阶用法

### 1. 实现生命周期钩子

```java
@SpringBootApplication
public class SampleApplication extends ZekaStarter {
    
    @Override
    public void before() {
        // 启动前处理：初始化配置、连接池等
        log.info("应用启动前处理");
    }
    
    @Override
    public void after() {
        // 启动后处理：预热缓存、启动定时任务等
        log.info("应用启动后处理");
    }
    
    @Override
    public void publishEvent(ConfigurableApplicationContext context) {
        // 发布启动完成事件
        context.publishEvent(new LauncherEvent(new Object()));
    }
}
```

### 2. 监听启动事件

```java
@Component
public class LauncherEventHandler {
    
    @EventListener
    public void handleLauncherEvent(LauncherEvent event) {
        // 处理启动完成事件
        log.info("应用启动完成，执行后续操作");
    }
}
```

### 3. 配置热更新

```yaml
# application.yml
cubo:
  launcher:
    refresh:
      enabled: true
      interval: 5000
```

### 4. 自定义启动类型

```java
@RunningType(ApplicationType.SERVICE)
@SpringBootApplication
public class SampleApplication extends ZekaStarter {
    // SERVICE: 服务应用
    // WEB: Web 应用
    // BATCH: 批处理应用
}
```

## 相关链接

- [[cubo-starter/cubo-launcher-spring-boot|应用启动器]]
