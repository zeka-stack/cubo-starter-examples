package dev.dong4j.zeka.starter.sample.logsystem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * <p>Description: 日志输出格式测试 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.26 14:52
 * @since 1.0.0
 */
@Slf4j
@ActiveProfiles("local")
class ChangeLogSystemPatternTest extends LogSystemApplicationTest {

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.07 19:40
     * @since 1.0.0
     */
    static class ConsolePattern extends ChangeLogSystemPatternTest {

        static {
            System.setProperty("zeka-stack.logging.pattern.console", "%clr{%d{yyyy-MM-dd HH:mm:ss.SSS}}{faint} %clr{[%5p]} [%traceId] [traceId] %clr{-}{faint} %clr{[%15.15t]}{faint} %location{.} %clr{::}{faint} %m%n%xwEx");
        }

        /**
         * Test
         *
         * @since 1.0.0
         */
        @Test
        void test() {

        }
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.07 19:40
     * @since 1.0.0
     */
    static class FilePattern extends ChangeLogSystemPatternTest {

        static {
            System.setProperty("zeka-stack.logging.pattern.console", "%d{yyyy-MM-dd HH:mm:ss.SSS} %5p [%traceId] - [%15.15t] %c{1.} :: %m%n%xwEx");
        }

        /**
         * Test
         *
         * @since 1.0.0
         */
        @Test
        void test() {

        }
    }

}
