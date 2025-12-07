---
published: 2022.05.23
---

# REST API 示例

## 概述

本示例项目展示了如何使用 `cubo-rest-spring-boot` 组件开发 RESTful API，包含 Servlet 和 Reactive 两种 Web 技术栈的完整示例。

## 子模块说明

### 1. cubo-rest-spring-boot-sample-servlet

基于 Spring MVC 的传统 Servlet Web 应用示例，展示了：

- **统一异常处理**：全局异常处理器自动捕获并格式化异常响应
- **参数验证**：基于 Bean Validation 的请求参数自动验证
- **响应封装**：统一的 API 响应格式，自动包装返回结果
- **配置热更新**：非 Spring Cloud 环境下的配置动态刷新
- **API 文档**：集成 Knife4j 自动生成和展示 API 文档
- **端点管理**：应用监控和管理端点

#### 核心特性演示

- 异常处理示例：`UserController` 展示了各种异常场景的处理
- 参数验证示例：`ResponseWrapperController` 展示了请求参数验证
- 配置热更新：`HotReloadController` 演示了配置动态刷新功能
- 字符串自动 Trim：`SpringTrimController` 展示了请求参数自动去除空格

### 2. cubo-rest-spring-boot-sample-reactive

基于 Spring WebFlux 的响应式 Web 应用示例，展示了：

- **响应式编程**：使用 Mono 和 Flux 处理异步请求
- **非阻塞 IO**：高并发场景下的性能优势
- **统一异常处理**：响应式环境下的异常处理机制

## 快速开始

### 运行 Servlet 示例

```bash
cd cubo-rest-spring-boot-sample-servlet
mvn spring-boot:run
```

访问 API 文档：http://localhost:8080/doc.html

### 运行 Reactive 示例

```bash
cd cubo-rest-spring-boot-sample-reactive
mvn spring-boot:run
```

## 高阶用法

### 1. 自定义异常处理

```java
@RestController
public class CustomController {
    
    @GetMapping("/test")
    public Result<String> test() {
        // 抛出业务异常，会被全局异常处理器自动捕获
        throw new BusinessException("业务异常");
    }
}
```

### 2. 参数验证

```java
@PostMapping("/user")
public Result<User> createUser(@Valid @RequestBody UserCreateRequest request) {
    // 参数会自动验证，验证失败会返回统一错误响应
    return R.succeed(userService.create(request));
}
```

### 3. 配置热更新

```java
@RestController
public class ConfigController {
    
    @Value("${app.name}")
    private String appName;
    
    @PostMapping("/reload")
    public Result<String> reloadConfig() {
        // 调用配置刷新接口后，@Value 注解的值会自动更新
        return R.succeed(appName);
    }
}
```

### 4. 响应式编程

```java
@RestController
public class ReactiveController {
    
    @GetMapping("/users")
    public Mono<Result<List<User>>> getUsers() {
        return userService.findAll()
            .map(R::succeed);
    }
}
```

## 相关链接

- [[cubo-starter/cubo-rest-spring-boot|REST API]]
