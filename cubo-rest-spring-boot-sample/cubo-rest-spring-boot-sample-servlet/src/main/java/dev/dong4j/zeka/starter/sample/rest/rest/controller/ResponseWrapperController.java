package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.exception.BaseException;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.ResponseWrapper;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: 测试 {@link ResponseWrapper} </p>
 *
 * @author dong4j
 * @version 1.2.4
 * @email "mailto:dongshijie@gmail.com"
 * @date 2020.02.04 12:05
 * @see ResponseWrapper
 * @since 1.0.0
 */
@Slf4j
@RestController
@ResponseWrapper
@RequestMapping("/wrapper")
public class ResponseWrapperController extends ServletController {

    /**
     * 直接返回实体, 自动包装为 Result<User> 返回
     *
     * @return the user
     * @since 1.0.0
     */
    @GetMapping("/xxx")
    public User test1() {
        return User.builder().name("dong4j").build();
    }

    /**
     * 直接返回 Result<User>, 忽略包装
     *
     * @return the result
     * @since 1.0.0
     */
    @GetMapping("/yyy")
    public Result<User> test2() {
        return this.ok(User.builder().name("dong4j").build());
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

    /**
     * Test 5
     *
     * @return the integer
     * @since 1.8.0
     */
    @GetMapping("/integer")
    public Integer test5() {
        return 1000;
    }

    /**
     * Test 6
     *
     * @return the string
     * @since 1.8.0
     */
    @GetMapping("/string")
    public String test6() {
        return "string";
    }

    /**
     * Test 7
     *
     * @return the string [ ]
     * @since 1.8.0
     */
    @GetMapping("/string.array")
    public String[] test7() {
        return new String[]{"string", "xxxxx"};
    }

    /**
     * Test 8
     *
     * @return the list
     * @since 1.8.0
     */
    @GetMapping("/list")
    public List<String> test8() {
        return new ArrayList<String>() {
            private static final long serialVersionUID = -5581968736445893760L;

            {
                this.add("aaaaa");
                this.add("bbbbb");
            }
        };
    }

}
