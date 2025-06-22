package dev.dong4j.zeka.starter.sample.logsystem;

import dev.dong4j.zeka.kernel.common.constant.App;
import org.junit.jupiter.api.Test;

/**
 * <p>Description: 修改日志时间格式 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.03 14:13
 * @since 1.0.0
 */
class ChangeDateFomatTest extends LogSystemApplicationTest {

    static {
        // idea 启动, 为本地开发环境, 默认使用 log4j2-console.xml 配置
        System.setProperty(App.START_TYPE, App.START_IDEA);
        System.setProperty("zeka-stack.logging.pattern.dateformat", "yyyy-MM-dd");
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
