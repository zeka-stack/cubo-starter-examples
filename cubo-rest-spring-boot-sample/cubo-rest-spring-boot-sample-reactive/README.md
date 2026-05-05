---
published: 2022.05.23
---

# REST API Reactive 示例

基于 Spring WebFlux 的响应式 Web 应用示例，展示 `cubo-rest-spring-boot` 在非阻塞 IO 场景下的使用方式。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

| 特性 | 说明 |
|------|------|
| 响应式编程 | 使用 Mono 和 Flux 处理异步请求 |
| 统一响应封装 | 响应式环境下同样使用 `R.succeed()` / `R.failed()` |
| 非阻塞 IO | 高并发场景下的性能优势 |

## 最小示例

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

- [[cubo-starter/cubo-rest-spring-boot/index|REST API 组件]]

