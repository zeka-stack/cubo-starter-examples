---
published: 2022.05.23
---

# 启动器示例（Patch 模式）

展示 `cubo-launcher-spring-boot` 的配置 Patch 能力，在不修改原始配置文件的情况下动态覆盖配置项。

## 运行方式

```bash
mvn spring-boot:run
```

## 演示特性

- 配置 Patch：通过 `cubo-launcher` 机制覆盖默认配置
- 环境感知：根据激活的 Profile 应用不同的 Patch 规则
- 非侵入式：原始 `application.yml` 保持不变

## 相关链接

- [[cubo-starter/cubo-launcher-spring-boot/index|应用启动器]]

