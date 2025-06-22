package dev.dong4j.zeka.starter.sample.logsystem;

import dev.dong4j.zeka.kernel.common.constant.App;
import org.junit.jupiter.api.Test;

/**
 * <p>Description: 修改日志文件保存路径 (对使用 log4j2-file.xml 有效) </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.03 14:13
 * @since 1.0.0
 */
class ChangeLogPathTest extends LogSystemApplicationTest {

    static {
        System.setProperty(App.START_TYPE, App.START_SHELL);
        System.setProperty("zeka-stack.logging.file.path", "log");
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
