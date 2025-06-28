package dev.dong4j.zeka.starter.sample.endpoint;

import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.endpoint.autoconfigure.reactive.ReactiveStartInfoAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试主类
 * 只应该装配 {@link ReactiveStartInfoAutoConfiguration}
 * 需要添加 WebEnvironment.RANDOM_PORT 或 DEFINED_PORT 才表示 Web 环境
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2025.06.28 19:00
 * @since 1.0.0
 */
@Slf4j
@ZekaTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleEndpointApplicationTest {

    @Test
    void test() {
        log.info("hello tester");
    }

}
