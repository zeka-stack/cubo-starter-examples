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
@ApiVersion({1, 2, 3})
@RestControllerWrapper("/api/version/class")
public class TestApiVersionOnClassController {

    /**
     * Hello 1
     *
     * @return the string
     * @since 2.0.0
     */
    @ApiVersion(9)
    @GetMapping("hello")
    public String hello1() {
        return "hello version1";
    }

    /**
     * Hello 2
     *
     * @return the string
     * @since 2.0.0
     */
    @GetMapping("hello")
    public String hello2() {
        log.info("haha2.........");

        return "hello version2";
    }


}
