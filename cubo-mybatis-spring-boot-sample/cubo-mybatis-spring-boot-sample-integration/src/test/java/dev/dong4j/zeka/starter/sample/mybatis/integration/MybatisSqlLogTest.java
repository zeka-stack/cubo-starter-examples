package dev.dong4j.zeka.starter.sample.mybatis.integration;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.mybatis.autoconfigure.MybatisAutoConfiguration;
import dev.dong4j.zeka.starter.mybatis.autoconfigure.MybatisProperties;
import dev.dong4j.zeka.starter.sample.mybatis.integration.service.UserService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2025.07.01 01:01
 * @since x.x.x
 */
@Slf4j
@ZekaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MybatisSqlLogTest {

    /** User service */
    @Resource
    private UserService userService;

    void test() {
        log.info("{}", this.userService.list().get(0).getId());
    }


    /**
     * 优先级最高, 覆盖配置文件
     *
     * @author dong4j
     * @version 1.0.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2025.07.01
     * @since 1.0.0
     */
    @Nested
    @ZekaTest(properties = "my.key=from-annotation")
    class MyPropertyTest {

        @Autowired
        Environment env;

        @Test
        void testKey() {
            assertEquals("from-annotation", env.getProperty("my.key"));
        }
    }

    /**
     * 如果 classpath 中不存在 p6spy 且非生产环境, 就启用 {@link MybatisAutoConfiguration#performanceInterceptor(MybatisProperties)} 输出日志
     *
     * @author dong4j
     * @version 1.0.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2025.07.01
     * @since 1.0.0
     */
    @Nested
    @ZekaTest(properties = {
        "spring.config.location=classpath:/application-nolog.yml"
    })
    class NoOutLogImplTest {
        @Autowired
        private MybatisPlusProperties props;

        @Test
        void testNoOutImpl() {
            // 默认配置
            assertEquals("dev.dong4j.zeka.starter.mybatis.logger.NoLogOutImpl",
                props.getConfiguration().getLogImpl().getName());
            test();
        }
    }

    /**
     * 修改默认的日志输出配置, 无视环境
     *
     * @author dong4j
     * @version 1.0.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2025.07.01
     * @since 1.0.0
     */
    @Nested
    @ZekaTest(properties = {
        "spring.config.location=classpath:/application-stdout.yml"
    })
    class StdOutLogImplTest {
        @Autowired
        private MybatisPlusProperties props;

        @Test
        void testStdOutImpl() {
            assertEquals("org.apache.ibatis.logging.stdout.StdOutImpl",
                props.getConfiguration().getLogImpl().getName());
            test();
        }
    }

    /**
     * 修改默认的日志输出配置, 无视环境
     *
     * @author dong4j
     * @version 1.0.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2025.07.01
     * @since 1.0.0
     */
    @Nested
    @ActiveProfiles("slf4j")
    @ZekaTest(properties = {
        "spring.config.location=classpath:/application-slf4j.yml"
    })
    class Slf4jLogImplTest {
        @Autowired
        private MybatisPlusProperties props;

        @Test
        void testSlf4jImpl() {
            assertEquals("org.apache.ibatis.logging.slf4j.Slf4jImpl",
                props.getConfiguration().getLogImpl().getName());
            test();
        }
    }

    @Nested
    @ZekaTest(properties = {
        "mybatis-plus.configuration.log-impl=dev.dong4j.zeka.starter.mybatis.logger.ZekaP6spySlf4jLogger"
    })
    class ZekaP6spySlf4jLoggerTest {
        @Autowired
        private MybatisPlusProperties props;

        @Test
        void testStdOutImpl() {
            assertEquals("dev.dong4j.zeka.starter.mybatis.logger.ZekaP6spySlf4jLogger",
                props.getConfiguration().getLogImpl().getName());
            test();
        }
    }
}
