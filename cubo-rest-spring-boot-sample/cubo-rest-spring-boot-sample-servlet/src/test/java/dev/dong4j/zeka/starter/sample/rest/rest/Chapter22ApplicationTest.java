package dev.dong4j.zeka.starter.sample.rest.rest;

import dev.dong4j.zeka.starter.sample.rest.SampleRestApplicationTest;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.09.17 15:33
 * @since 1.6.0
 */
@Slf4j
@WebAppConfiguration
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Chapter22ApplicationTest extends SampleRestApplicationTest {
    /** Mock mvc */
    @Resource
    protected MockMvc mockMvc;

    /**
     * Test
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        log.info("{}", isPresent("org.springframework.boot.SpringApplication"));
        log.info("{}", isPresent("org.springframework.boot.autoconfigure.SpringBootApplication"));
        log.info("{}", isPresent("org.springframework.cloud.client.SpringCloudApplication"));
    }

    /**
     * Is present boolean
     *
     * @param name name
     * @return the boolean
     * @since 1.0.0
     */
    static boolean isPresent(String name) {
        try {
            Thread.currentThread().getContextClassLoader().loadClass(name);
            return true;
        } catch (ClassNotFoundException ignored) {
        }
        return false;
    }
}
