package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.web.support.CacheRequestEnhanceWrapper;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.RequestSingleParam;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import dev.dong4j.zeka.starter.rest.converter.StringToDateConverter;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.enums.UserStatusEnum;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: RequestSingleParam 注解测试 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 16:40
 * @see RequestSingleParamHandlerMethodArgumentResolver
 * @since 1.0.0
 */
@Slf4j
@RestController
@SuppressWarnings("all")
@RestControllerWrapper("/param")
public class RequestSingleParamController extends ServletController {

    /**
     * 2020-01-03 20:47 dong4j 不再支持, 使用 {@link EnumController#convert_4} 的方式
     * GET http://127.0.0.1:18080/param/1
     * <p>
     * {
     * "name": "dong4j",
     * "status": 1
     * }
     *
     * @param status status
     * @param name   name
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public Result<UserStatusEnum> param_1(@RequestSingleParam("status") UserStatusEnum status,
                                          @RequestSingleParam("name") String name) {
        return this.ok(status);
    }

    /**
     * 通过 value()
     * POST http://127.0.0.1:18080/param/2
     * <p>
     * {
     * "name": "dong4j",
     * "status": 1
     * }
     * <p>
     * ###
     * 通过 name()
     * POST http://127.0.0.1:18080/param/2
     * <p>
     * {
     * "name": "dong4j",
     * "status": "CHECK_FAILED"
     * }
     * ###
     * 通过 ordinal()
     * POST http://127.0.0.1:18080/param/2
     * <p>
     * {
     * "name": "dong4j",
     * "status": 5
     * }
     *
     * @param status status
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @RequestMapping(value = "/2", method = RequestMethod.POST)
    public Result<UserStatusEnum> param_2(@RequestSingleParam("status") UserStatusEnum status) {
        return this.ok(status);
    }

    /**
     * 和 {@link RequestSingleParamController#param_2} 相同
     *
     * @param status status
     * @param name   name
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @RequestMapping(value = "/3", method = RequestMethod.POST)
    public Result<UserStatusEnum> param_3(@RequestSingleParam("status") UserStatusEnum status,
                                          @RequestSingleParam("name") String name) {
        return this.ok(status);
    }

    /**
     * 测试 get 请求时传递单个参数: 入参 {"name": "dong4j"}, 使用单个字段接收, 多个字段必须使用 {@link CacheRequestEnhanceWrapper}
     * <p>
     * POST http://127.0.0.1:18080/param/4
     * <p>
     * {
     * "name": "dong4j"
     * }
     * <p>
     * 2020-01-03 14:00 dong4j 做了限制, 不再支持 get, get 可直接使用 @RequestParam
     *
     * @param name name
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @RequestMapping(value = "/4", method = RequestMethod.GET)
    public Result<String> param_4(@RequestSingleParam("name") String name) {
        return this.ok(name);
    }

    /**
     * post 请求传入一个 json 字符串, 绑定到单独的字段上, 在字段较少的情况下不使用实体接收参数,
     * 如果是多个字段, 必须确保 HttpServletRequest 是 {@link CacheRequestEnhanceWrapper}
     * <p>
     * POST http://127.0.0.1:18080/param/5
     * <p>
     * {
     * "name": "dong4j",
     * "age": 1
     * }
     *
     * @param name name
     * @param age  age
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @RequestMapping(value = "/5", method = RequestMethod.POST)
    public Result<String> param_5(@RequestSingleParam("name") String name,
                                  @RequestSingleParam("age") Integer age) {
        return this.ok(name);
    }

    /**
     * 时间字符串转 Date 类型 (这种方式不能绑定)
     *
     * @param time time
     * @return the result
     * @since 1.0.0
     */
    @RequestMapping(value = "/6", method = RequestMethod.GET)
    public Result<String> param_6(Date time) {
        return this.ok(time.toString());
    }

    /**
     * Test 4 result
     * GET http://127.0.0.1:18080/param/7?time=2019-12-12 10:00:00
     * <p>
     * GET http://127.0.0.1:18080/param/7
     * Content-Type: application/x-www-form-urlencoded
     * \n
     * time=2019-12-12 10:00:00
     *
     * @param time time
     * @return the result
     * @see StringToDateConverter
     * @since 1.0.0
     */
    @RequestMapping(value = "/7", method = RequestMethod.GET)
    public Result<String> param_7(@RequestParam("time") Date time) {
        return this.ok(time.toString());
    }

    /**
     * Test 5 result
     *
     * @param time time
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @RequestMapping(value = "/8", method = RequestMethod.POST)
    public Result<String> param_8(@RequestSingleParam("time") Date time) {
        return this.ok(time.toString());
    }

    /**
     * 多参数单独绑定
     *
     * @param time time
     * @param name name
     * @param age  age
     * @param age2 age 2
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @RequestMapping(value = "/9", method = RequestMethod.POST)
    public Result<String> param_9(@RequestSingleParam("time") Date time,
                                  @RequestSingleParam("name") String name,
                                  @RequestSingleParam("age") int age,
                                  @RequestSingleParam("age2") Integer age2
    ) {
        log.info("{}", time);
        log.info("{}", name);
        log.info("{}", age);
        log.info("{}", age2);
        return this.ok();
    }


}
