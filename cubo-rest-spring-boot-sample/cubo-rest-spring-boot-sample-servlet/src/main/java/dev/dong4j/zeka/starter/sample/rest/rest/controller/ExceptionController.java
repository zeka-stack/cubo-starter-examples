package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.BaseCodes;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.form.LoginForm;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import dev.dong4j.zeka.starter.sample.rest.rest.service.ExceptionService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: 统一异常处理测试 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 13:27
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/exception")
public class ExceptionController extends ServletController {

    /** Exception service */
    @Resource
    private ExceptionService exceptionService;

    /**
     * 测试注解验
     *
     * @param loginForm login form
     * @return the result
     * @since 1.0.0
     */
    @PostMapping("/test1")
    public Result<User> test1(@RequestBody @NotNull LoginForm loginForm) {
        return this.ok(this.exceptionService.exception(loginForm.getCode()));
    }

    /**
     * Random exception
     *
     * @since 1.0.0
     */
    @GetMapping("/random_exception")
    public void randomException() {
        this.exceptionService.randomException();
    }

    /**
     * Exception result
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping
    public Result<Void> exception() {
        throw new RuntimeException();
    }

    /**
     * 异常包装
     *
     * @since 1.6.0
     */
    @GetMapping("/wrapper")
    public void wrapper() {
        BaseCodes.DATA_ERROR.wrapper(() -> {
            log.info("异常转换");
            this.exceptionService.exception("");
        });

        BaseCodes.DATA_ERROR.wrapper(() -> {
            log.info("异常转换");
            this.exceptionService.exception("");
        }, "异常日志转换消息");
    }
}
