package dev.dong4j.zeka.starter.sample.mybatis.integration;

import dev.dong4j.zeka.kernel.common.constant.ConfigKey;
import dev.dong4j.zeka.kernel.common.context.SpringContext;
import dev.dong4j.zeka.kernel.common.util.ConfigKit;
import dev.dong4j.zeka.kernel.test.ZekaTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:12
 * @since 1.0.0
 */
@Slf4j
@ZekaTest
@TestPropertySource(locations = "classpath:application-junit.yml")
public class MybatisApplicationTest {
    /**
     * Sets up
     */
    @BeforeAll
    static void setUp() {
        log.info("start ExampleApplication test");
    }

    /**
     * Tear down
     *
     * @since 1.0.0
     */
    @AfterAll
    static void tearDown() {
        log.info("end ExampleApplication test");
    }

    /**
     * Test
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        log.info("{}", SpringContext.getApplicationContext().getEnvironment().getProperty(ConfigKey.SpringConfigKey.APPLICATION_NAME));
    }

    /**
     * Test configkit
     *
     * @since 1.0.0
     */
    @Test
    void test_configkit() {
        log.info("{}", ConfigKit.getConfigFile("application-junit.yml"));
    }
}
