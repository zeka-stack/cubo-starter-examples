package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: xss 攻击测试 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.11 17:44
 * @since 1.0.0
 */
@Slf4j
@Tag(name = "Xss 攻击测试")
@Validated
@RestController
public class XssController extends ServletController {

    /**
     * POST <a href="http://127.0.0.1:18080/xss?name=">...</a><script>alert('hello');</script>
     * <p>
     * 输出:
     * {
     * "code": 2000,
     * "success": true,
     * "data": "alert('hello');",
     * "message": "处理成功",
     * "traceId": ""
     * }
     *
     * @param name name
     * @return the object
     * @since 1.0.0
     */
    @PostMapping(value = "/xss")
    public Result<String> test(String name) {
        return this.ok(name);
    }

    /**
     * POST <a href="http://127.0.0.1:18080/json">...</a>
     * Content-Type: application/json
     * <p>
     * {
     * "id": 1,
     * "name": "<script>alert('hello');</script>",
     * "age": 1,
     * "address": "demoData",
     * "email": "demoData",
     * "date": "2020-01-11 18:06:00"
     * }
     * 输出:
     * {
     * "code": 2000,
     * "success": true,
     * "data": {
     * "id": 1,
     * "name": "alert('hello');",
     * "age": 1,
     * "address": "demoData",
     * "email": "demoData",
     * "date": "2020-01-11 18:06:00"
     * },
     * "message": "处理成功",
     * "traceId": ""
     * }
     *
     * @param param param
     * @return the object
     * @since 1.0.0
     */
    @PostMapping(value = "/json")
    public Result<User> testJson(@RequestBody User param) {
        return this.ok(param);
    }

    /**
     * GET <a href="http://127.0.0.1:18080/query?q=">...</a><script>alert('hello');</script>
     *
     * @param q q
     * @return the object
     * @since 1.0.0
     */
    @GetMapping(value = "/query")
    public Result<String> testQuery(String q) {
        return this.ok(q);
    }

}
