package dev.dong4j.zeka.starter.sample.endpoint;

import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.endpoint.autoconfigure.EndpointAutoConfiguration;
import dev.dong4j.zeka.starter.endpoint.autoconfigure.reactive.ReactiveStartInfoAutoConfiguration;
import dev.dong4j.zeka.starter.endpoint.autoconfigure.servlet.ServletStartInfoAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 测试主类
 * 不添加任何 WEB 相关的依赖, 以下装配类不应该被自动装配:
 * 1. {@link EndpointAutoConfiguration}
 * 2. {@link ServletStartInfoAutoConfiguration}
 * 3. {@link ReactiveStartInfoAutoConfiguration}
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2025.06.28 19:00
 * @since 1.0.0
 */
@Slf4j
@ZekaTest
public class SampleEndpointApplicationTest {

    @Test
    void test() {
        log.info("hello tester");
    }
}
