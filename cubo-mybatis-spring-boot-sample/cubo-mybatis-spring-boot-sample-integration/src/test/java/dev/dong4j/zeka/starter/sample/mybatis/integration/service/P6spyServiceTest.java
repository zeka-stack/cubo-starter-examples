package dev.dong4j.zeka.starter.sample.mybatis.integration.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestPropertySource;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.01.25 23:53
 * @since 1.7.1
 */
@TestPropertySource(locations = "classpath:application-junit-p6spy.yml")
public class P6spyServiceTest extends UserServiceTest {

    /**
     * Test
     *
     * @since 1.7.1
     */
    @Test
    @Override
    void test() {
        super.test();

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
