# SqlExecuteTimeoutEvent

当 sql 执行时间超过 `zeka-stack.mybatis.performmax-time` 配置的时间会发送 `SqlExecuteTimeoutEvent` 事件, 目前需要业务端自己处理此事件, 推荐存入
mongodb, 后期将通过消息总线统一存储.

# 新增配置

```yaml
zeka-stack:
  mybatis:
    # sql 耗时超过此时间将发送 SqlExecuteTimeoutEvent, 单位毫秒
    performmax-time: 300
    # 输出到日志的 sql 日志是否格式化
    sql-format: false
```

# todo

1. 统一使用 `p6spy` 代替 `PerformanceInterceptor`;
2. 重写 `P6spyAutoConfiguration`, 完成如下功能:
    1. 记录所有的 SQL;
    2. 如果超过配置的执行时间, 则发送 `SqlExecuteTimeoutEvent` 事件;
    3. 自动替换 url, 兼容老的 url, 无需业务端配置;
    4. 修改 `spring.datasource.driver-class-name` 为 `com.p6spy.engine.spy.P6SpyDriver`, 无需业务端配置 (
       dev.dong4j.zeka.kernel.common.constant.ConfigKey.DruidConfigKey.DRIVER_CLASS);
3. 使用消息总线统一存储 SQL 慢日志;
