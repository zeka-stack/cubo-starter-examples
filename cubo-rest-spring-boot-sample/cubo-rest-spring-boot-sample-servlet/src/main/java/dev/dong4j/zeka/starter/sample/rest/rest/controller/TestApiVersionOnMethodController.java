package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.starter.rest.annotation.ApiVersion;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 2.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.09.26 11:25
 * @since 2.0.0
 */
@Slf4j
@RestControllerWrapper("/api/version/method")
public class TestApiVersionOnMethodController {

    /**
     * Hello 1
     *
     * @return the string
     * @since 2.0.0
     */
    @ApiVersion(1)
    @GetMapping("hello1")
    public String hello1() {
        return "hello version1";
    }

    /**
     * Hello 2
     *
     * @return the string
     * @since 2.0.0
     */
    @ApiVersion(2)
    @GetMapping("hello2")
    public String hello2() {
        log.info("haha2.........");

        return "hello version2";
    }

    /**
     * Hello 3
     *
     * @return the string
     * @since 2.0.0
     */
    @ApiVersion(3)
    @GetMapping("hello3")
    public String hello3() {
        log.info("haha2.........");

        return "hello version2";
    }

    /**
     * Hello 5
     *
     * @return the string
     * @since 2.0.0
     */
    @ApiVersion({5, 6, 7})
    @GetMapping("hello567")
    public String hello5() {
        log.info("haha5.........");
        return "hello version5、6、7";
    }

    /**
     * Hello
     *
     * @return the string
     * @since 2.0.0
     */
    @GetMapping("hello")
    public String hello() {
        return "hello, 没有版本";
    }

}
