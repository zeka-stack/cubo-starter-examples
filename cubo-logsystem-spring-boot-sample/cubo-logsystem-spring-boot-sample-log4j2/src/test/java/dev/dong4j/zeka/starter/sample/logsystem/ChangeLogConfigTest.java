package dev.dong4j.zeka.starter.sample.logsystem;

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
class ChangeLogConfigTest extends LogSystemApplicationTest {

    static {
        // 修改日志配置文件
        System.setProperty("zeka-stackzeka-stack.logging.config", "log4j2-json.xml");
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
