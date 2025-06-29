package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.exception.BaseException;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Description: 测试组合注解 {@link RestControllerWrapper} </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dongshijie@gmail.com"
 * @date 2020.02.04 12:51
 * @since 1.0.0
 */
@Slf4j
@RestControllerWrapper(value = "/test", name = "自定义组合注解")
public class ServletControllerWrapperController extends ServletController {
    /**
     * 直接返回实体, 自动包装为 Result<User> 返回
     *
     * @return the user
     * @since 1.0.0
     */
    @GetMapping("/xxx")
    public User test1() {
        return User.builder().name("dong4j").date(new Date()).build();
    }

    /**
     * 直接返回实体, 自动包装为 Result<User> 返回
     *
     * @return the user
     * @since 1.0.0
     */
    @GetMapping("/yyy")
    public Result<User> test2() {
        return this.ok(User.builder().name("dong4j").date(new Date()).build());
    }

    /**
     * 异常测试.
     * 如果发生异常, 将有全局异常处理器统一包装为 Result
     *
     * @return the user
     * @since 1.0.0
     */
    @GetMapping("/exception")
    public User test3() {
        throw new BaseException("异常测试");
    }

    /**
     * 没有返回结果, 将包装为 Result<Void>
     * {
     * "code": 2000,
     * "success": true,
     * "data": {},
     * "message": "处理成功",
     * "traceId": ""
     * }
     *
     * @since 1.0.0
     */
    @GetMapping("/void")
    public void test4() {
        log.info("没有返回");
    }

}
