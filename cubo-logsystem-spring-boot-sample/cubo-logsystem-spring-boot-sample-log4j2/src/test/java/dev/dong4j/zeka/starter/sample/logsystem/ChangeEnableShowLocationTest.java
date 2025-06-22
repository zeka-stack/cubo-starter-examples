package dev.dong4j.zeka.starter.sample.logsystem;

import dev.dong4j.zeka.kernel.common.constant.App;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.26 14:52
 * @since 1.0.0
 */
@Slf4j
@ActiveProfiles("local")
class ChangeEnableShowLocationTest extends LogSystemApplicationTest {

    /**
     * <p>Description: 本地开发, 不需要配置默认开启 location  </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.03 13:46
     * @since 1.0.0
     */
    static class LocalEnvTest1 extends ChangeEnableShowLocationTest {

        static {
            System.setProperty(App.START_TYPE, App.START_IDEA);
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
     * <p>Description: 本地开发, 显式开启 location 配置 </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.03 13:46
     * @since 1.0.0
     */
    static class LocalEnvTest2 extends ChangeEnableShowLocationTest {

        static {
            System.setProperty(App.START_TYPE, App.START_IDEA);
            // 是否显示 location 信息
            System.setProperty("zeka-stack.logging.enable-show-location", "true");
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
     * <p>Description: 非本地开发, 默认关闭 location </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.03 14:10
     * @since 1.0.0
     */
    static class DevEnvTest1 extends ChangeEnableShowLocationTest {

        static {
            System.setProperty(App.START_TYPE, App.START_SHELL);
            // 使用 log4j2-console.xml 来测试
            System.setProperty("zeka-stack.logging.config", "log4j2-console.xml");
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
     * <p>Description: 非本地开发, 显式开启 location 配置 </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.03 14:10
     * @since 1.0.0
     */
    static class DevEnvTest2 extends ChangeEnableShowLocationTest {

        static {
            System.setProperty(App.START_TYPE, App.START_SHELL);
            // 使用 log4j2-console.xml 来测试
            System.setProperty("zeka-stack.logging.config", "log4j2-console.xml");
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

