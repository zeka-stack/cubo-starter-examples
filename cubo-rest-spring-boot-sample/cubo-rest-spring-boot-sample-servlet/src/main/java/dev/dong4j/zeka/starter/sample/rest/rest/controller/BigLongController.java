package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.base.AbstractBaseEntity;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.TestEntity;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.09.28 20:36
 * @since 2.0.0
 */
@Slf4j
@RestController
@SuppressWarnings("all")
@RestControllerWrapper("/big-long")
@Api(value = "大于 9007199254740991 long 转换为 String", tags = "big-long-test")
public class BigLongController extends ServletController {

    /**
     * Test 1
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test1")
    public Result<Long> test1() {
        return this.ok(9007199254740991L);
    }

    /**
     * Test 2
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test2")
    public Result<Long> test2() {
        return this.ok(9007199254740991L);
    }

    /**
     * Test 3
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test3")
    public Result<Long> test3() {
        return this.ok(1106023578035290121L);
    }

    /**
     * Test 4
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test4")
    public Result<List<Long>> test4() {
        return this.ok(new ArrayList<Long>() {
            {
                add(9007199254740991L);
            }
        });
    }

    /**
     * Test 5
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test5")
    public Result<List<Long>> test5() {
        return this.ok(new ArrayList<Long>() {
            {
                add(9007199254740991L);
            }
        });
    }

    /**
     * Test 6
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test6")
    public Result<List<Long>> test6() {
        return this.ok(new ArrayList<Long>() {
            {
                add(1106023578035290121L);
            }
        });
    }

    /**
     * Test 7
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test7")
    public Result<AbstractBaseEntity> test7() {
        return this.ok(TestEntity.builder().build().setId(9007199254740991L));
    }

    /**
     * Test 8
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test8")
    public Result<AbstractBaseEntity> test8() {
        return this.ok(TestEntity.builder().build().setId(9007199254740991L));
    }

    /**
     * Test 9
     *
     * @return the result
     * @since 2.0.0
     */
    @GetMapping("/test9")
    public Result<AbstractBaseEntity> test9() {
        return this.ok(TestEntity.builder().build().setId(1106023578035290121L));
    }
}
