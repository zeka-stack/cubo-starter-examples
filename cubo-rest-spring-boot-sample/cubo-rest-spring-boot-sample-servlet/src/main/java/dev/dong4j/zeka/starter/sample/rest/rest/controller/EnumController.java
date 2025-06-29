package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.enums.UserStatusEnum;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.form.UserForm;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.EnumEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: 枚举序列化与反序列化 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 14:44
 * @since 1.0.0
 */
@Slf4j
@RestController
@SuppressWarnings("all")
@RestControllerWrapper("/enum")
public class EnumController extends ServletController {

    /**
     * 实体序列化
     * GET http://127.0.0.1:18080/enum/convert_1
     *
     * @return the enum entity
     * @since 1.0.0
     */
    @GetMapping("/convert_1")
    public EnumEntity convert_1_get() {

        return EnumEntity.builder()
            .name("dong4j")
            .status(UserStatusEnum.CHECK_FAILED)
            .statusList(new ArrayList<UserStatusEnum>(2) {
                private static final long serialVersionUID = -1544138039168616180L;

                {
                    this.add(UserStatusEnum.CHECKED);
                    this.add(UserStatusEnum.CHECKING);
                }
            })
            .statusMap(new HashMap<String, UserStatusEnum>(2) {
                private static final long serialVersionUID = -5422635556981397153L;

                {
                    this.put("xxx", UserStatusEnum.CHECKED);
                    this.put("yyy", UserStatusEnum.CHECKING);
                }
            })
            .build();
    }

    /**
     * 直接返回枚举
     * POST http://127.0.0.1:18080/enum/convert_1
     *
     * @return the enum entity
     * @since 1.0.0
     */
    @PostMapping("/convert_1")
    public UserStatusEnum convert_1_post() {
        return UserStatusEnum.CHECK_FAILED;
    }

    /**
     * 实体序列化与枚举反序列化 (GET), 这种方式接收到不到参数, get 参数必须使用 @RequestParam 绑定参数
     *
     * @param status status
     * @return the enum entity
     * @since 1.0.0
     */
    @GetMapping("/convert_2")
    public EnumEntity convert_2_get(UserStatusEnum status) {
        log.info("input = {}", status);
        return EnumEntity.builder().name("dong4j").status(status).build();
    }

    /**
     * 通过 value 和 name 来匹配枚举
     * GET http://127.0.0.1:18080/enum/convert_3?status=1
     * GET http://127.0.0.1:18080/enum/convert_3?status=NOT_CHECK
     *
     * @param status status
     * @return the result
     * @see TypeConverterDelegate#attemptToConvertStringToEnum(Class, String, Object)
     * @see GlobalEnumConverterFactory
     * @since 1.0.0
     */
    @GetMapping("/convert_3")
    public Result<UserStatusEnum> convert_3(@RequestParam("status") UserStatusEnum status) {
        return this.ok(status);
    }

    /**
     * 多参数绑定, 枚举处理
     * GET http://127.0.0.1:18080/test/convert/7?status=1&name=dong4j
     *
     * @param status status
     * @param name   name
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @GetMapping("/convert_4")
    public Result<EnumEntity> convert_4(@RequestParam("status") UserStatusEnum status,
                                        @RequestParam("name") String name) {
        return this.ok(EnumEntity.builder().name(name).status(status).build());
    }

    /**
     * 通过 value()
     * POST http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/json
     * <p>
     * {
     * "value": 5
     * }
     * ###
     * <p>
     * 通过 name()
     * POST http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/json
     * <p>
     * {
     * "value": "CHECK_FAILED"
     * }
     * <p>
     * ###
     * <p>
     * 通过 ordinal()
     * POST http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/json
     * <p>
     * {
     * "value": 0
     * }
     * 通过 json 来查找枚举, value 支持 getValue, name(), ordinal()
     *
     * @param status status
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @PostMapping(value = "/convert_2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserStatusEnum> convert_2_post(@RequestBody UserStatusEnum status) {
        return this.ok(status);
    }

    /**
     * 通过 value()
     * PUT http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/json
     * <p>
     * {
     * "value": 5
     * }
     * ###
     * <p>
     * 通过 name()
     * POST http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/json
     * <p>
     * {
     * "value": "CHECK_FAILED"
     * }
     * <p>
     * ###
     * <p>
     * 通过 ordinal()
     * POST http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/json
     * <p>
     * {
     * "value": 0
     * }
     * 通过 json 来查找枚举, value 支持 getValue, name(), ordinal()
     *
     * @param status status
     * @return the result 返回实体, 其中包含枚举字段
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @PutMapping(value = "/convert_2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserStatusEnum> convert_2_put(@RequestBody UserStatusEnum status) {
        return this.ok(status);
    }

    /**
     * 使用 application/x-www-form-urlencoded 请求接口, 不需要参数绑定
     * 通过 value()
     * PATCH http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/x-www-form-urlencoded
     * <p>
     * status=5
     * ###
     * <p>
     * 通过 name()
     * PATCH http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/x-www-form-urlencoded
     * <p>
     * status=CHECK_FAILED
     * ###
     * <p>
     * 通过 ordinal()
     * PATCH http://127.0.0.1:18080/enum/convert_2
     * Content-Type: application/x-www-form-urlencoded
     * <p>
     * status=0
     * ###
     *
     * @param status status
     * @return the result
     * @see RequestSingleParamHandlerMethodArgumentResolver
     * @since 1.0.0
     */
    @PatchMapping(value = "/convert_2", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Result<UserStatusEnum> convert_2_patch(UserStatusEnum status) {
        return this.ok(status);
    }

    /**
     * POST /enum/convert_object HTTP/1.1
     * Host: 192.168.31.6:18197
     * Content-Type: application/x-www-form-urlencoded
     * <p>
     * name=xxxxx&age=10&address=arraydsj@163.com&email=arraydsj@163.com&status=1
     * <p>
     * POST /enum/convert_object HTTP/1.1
     * Host: 192.168.31.6:18197
     * Content-Type: application/x-www-form-urlencoded
     * <p>
     * name=xxxxx&age=10&address=arraydsj@163.com&email=arraydsj@163.com&status=NOT_CHECK
     *
     * @param form form
     * @return the result
     * @since 1.6.0
     */
    @PostMapping(value = "/convert_object", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Result<UserForm> convert_object_form(@Valid UserForm form) {
        return this.ok(form);
    }

    /**
     * PUT /enum/convert_object HTTP/1.1
     * Host: 192.168.31.6:18132
     * Content-Type: application/json
     * <p>
     * 1. 直接使用 枚举的 value
     * {
     * "name": "demoData",
     * "age": 10,
     * "address": "arraydsj@163.com",
     * "email": "demoData",
     * "date": "2020-09-30 11:53:18",
     * "status": 1
     * }
     * <p>
     * 2. json 格式
     * {
     * "name": "demoData",
     * "age": 10,
     * "address": "demoData",
     * "email": "arraydsj@163.com",
     * "date": "2020-09-30 11:53:18",
     * "status": {
     * "value": 1
     * }
     * <p>
     * 3. 直接使用枚举值
     * {
     * "name": "demoData",
     * "age": 10,
     * "address": "demoData",
     * "email": "arraydsj@163.com",
     * "date": "2020-09-30 11:53:18",
     * "status": {
     * "value": "NOT_CHECK"
     * }
     * <p>
     * 4. 使用 json 格式的枚举值
     * {
     * "name": "demoData",
     * "age": 10,
     * "address": "demoData",
     * "email": "arraydsj@163.com",
     * "date": "2020-09-30 11:53:18",
     * "status": {
     * "value": "NOT_CHECK"
     * }
     * }
     *
     * @param form form
     * @return the result
     * @since 1.6.0
     */
    @PutMapping(value = "/convert_object", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserForm> convert_object_json(@RequestBody @Valid UserForm form) {
        return this.ok(form);
    }

}
