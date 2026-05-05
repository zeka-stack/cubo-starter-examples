# REST API Servlet 示例

基于 Spring MVC 的传统 Servlet Web 应用示例，展示 `cubo-rest-spring-boot` 的核心能力。

## 运行方式

```bash
mvn spring-boot:run
```

启动后访问 API 文档：http://localhost:8080/doc.html

## 演示特性

| 特性 | 演示类 | 说明 |
|------|--------|------|
| 统一异常处理 | `UserController` | 各种异常场景的自动捕获和格式化响应 |
| 参数验证 | `ResponseWrapperController` | Bean Validation 自动校验请求参数 |
| 配置热更新 | `HotReloadController` | 非 Spring Cloud 环境下的配置动态刷新 |
| 字符串自动 Trim | `SpringTrimController` | 请求参数自动去除首尾空格 |
| 统一响应封装 | 全局生效 | `R.succeed()` / `R.failed()` 统一响应格式 |
| Knife4j 文档 | 自动集成 | 无需额外配置即生成 API 文档 |

## 最小示例

```java
@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable Long id) {
        return R.succeed(userService.getById(id));
    }

    @PostMapping("/user")
    public Result<User> createUser(@Valid @RequestBody UserCreateRequest request) {
        return R.succeed(userService.create(request));
    }
}
```

## 相关链接

- [[cubo-starter/cubo-rest-spring-boot/index|REST API 组件]]
