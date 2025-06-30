package dev.dong4j.zeka.starter.sample.mybatis.integration.service;

import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.form.UserQuery;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用 spring.config.location=classpath:/application-junit-p6spy.yml 只加载单独的配置, 不会加载 application.yml
 *
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.01.25 23:53
 * @since 1.7.1
 */
@Slf4j
@ZekaTest(properties = {
    "spring.config.location=classpath:/application-junit-p6spy.yml"
})
public class P6spyServiceTest {

    /** User service */
    @Resource
    private UserService userService;

    /**
     * Test
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        log.info("{}", this.userService.list().size());
        log.info("{}", this.userService.list());
        log.info("{}", this.userService.list().get(0).getId());
    }

    /**
     * Test 3
     *
     * @since 1.6.0
     */
    @Test
    void test3() {
        UserQuery query = UserQuery.builder().build();
        query.setUserName("dong4j");
        log.info("{}", this.userService.list(query).size());
    }

    /**
     * Test transactional
     *
     * @since 1.7.1
     */
    @Test
    void test_transactional() {
        this.userService.transactional();
    }

    /**
     * Test
     *
     * @since 1.7.1
     */
    @Test
    void testxx() {

        int a = 0;
        Logger p6spy = LoggerFactory.getLogger("p6spy");
        System.setProperty("zeka-stack.logging.level.root", "debug");
        if (p6spy.isDebugEnabled()) {
            a = 1;
        }
        Assertions.assertEquals(1, a);

        System.setProperty("zeka-stack.logging.level.root", "info");
        if (p6spy.isInfoEnabled()) {
            a = 2;
        }
        Assertions.assertEquals(2, a);

        System.setProperty("zeka-stack.logging.level.root", "warn");
        if (p6spy.isWarnEnabled()) {
            a = 3;
        }
        Assertions.assertEquals(3, a);

        System.setProperty("zeka-stack.logging.level.root", "error");
        if (p6spy.isErrorEnabled()) {
            a = 4;
        }
        Assertions.assertEquals(4, a);

    }
}
