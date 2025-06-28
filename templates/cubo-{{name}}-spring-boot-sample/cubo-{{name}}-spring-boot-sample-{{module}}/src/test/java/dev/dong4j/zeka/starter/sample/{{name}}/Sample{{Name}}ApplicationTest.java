package dev.dong4j.zeka.starter.sample.{{name}};

import dev.dong4j.zeka.kernel.test.ZekaTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 测试主类
 * 
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date {{date}}
 * @since 1.0.0
 */
@Slf4j
@ZekaTest
public class Sample{{Name}}ApplicationTest {

    @Test
    void test() {
        log.info("hello tester");
    }
}
