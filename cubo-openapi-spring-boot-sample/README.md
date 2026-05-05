---
published: 2022.05.23
---

# API 文档示例

## 概述

本示例项目展示了如何使用 `cubo-openapi-spring-boot` 组件生成和管理 API 文档，支持 Knife4j 和 Dubbo 两种文档工具。

## 子模块说明

### 1. cubo-openapi-spring-boot-sample-knife4j

**Knife4j 文档示例**，展示了：

- 基于 Swagger 3.0 的 API 文档生成
- 增强的 UI 界面和调试功能
- 分组管理和权限控制

### 2. cubo-openapi-spring-boot-sample-dubbo

**Dubbo 接口文档示例**，展示了：

- Dubbo 服务的 API 文档生成
- 服务接口的自动扫描和展示

## 快速开始

### 运行 Knife4j 示例

```bash
cd cubo-openapi-spring-boot-sample-knife4j
mvn spring-boot:run
```

访问文档：http://localhost:8080/doc.html

### 运行 Dubbo 示例

```bash
cd cubo-openapi-spring-boot-sample-dubbo
mvn spring-boot:run
```

## 高阶用法

### 1. 基础 API 文档配置

```java
@RestController
@Api(tags = "用户管理")
public class UserController {
    
    @GetMapping("/users/{id}")
    @ApiOperation(value = "获取用户", notes = "根据 ID 获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    public Result<User> getUser(@PathVariable Long id) {
        return R.succeed(userService.getById(id));
    }
}
```

### 2. 分组管理

```java
@Configuration
public class OpenApiConfig {
    
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("public")
            .pathsToMatch("/public/**")
            .build();
    }
    
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
            .group("admin")
            .pathsToMatch("/admin/**")
            .build();
    }
}
```

### 3. 安全配置

```java
@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components()
            .addSecuritySchemes("bearer-jwt",
                new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
}
```

### 4. 自定义文档信息

```yaml
springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
  info:
    title: API 文档
    version: 1.0.0
    description: 系统 API 文档
```

### 5. 接口版本控制

```java
@RestController
@RequestMapping("/v1/users")
@ApiVersion("1.0")
public class UserV1Controller {
    // v1 版本的接口
}

@RestController
@RequestMapping("/v2/users")
@ApiVersion("2.0")
public class UserV2Controller {
    // v2 版本的接口
}
```

## 相关链接

- [[cubo-starter/cubo-openapi-spring-boot/index|API 文档]]
