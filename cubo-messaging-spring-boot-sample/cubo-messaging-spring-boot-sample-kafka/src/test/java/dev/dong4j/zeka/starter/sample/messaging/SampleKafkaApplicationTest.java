package dev.dong4j.zeka.starter.sample.messaging;

import dev.dong4j.zeka.kernel.test.ZekaTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2025.06.25 01:13
 * @since x.x.x
 */
@Slf4j
@ZekaTest(classes = SampleKafkaApplication.class)
public class SampleKafkaApplicationTest {
    @Test
    void test() {
        log.info("hello tester");
    }

}
