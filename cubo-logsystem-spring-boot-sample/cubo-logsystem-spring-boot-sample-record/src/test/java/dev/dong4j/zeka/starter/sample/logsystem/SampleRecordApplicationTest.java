package dev.dong4j.zeka.starter.sample.logsystem;

import dev.dong4j.zeka.kernel.test.ZekaTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.22 13:25
 * @since 1.0.0
 */
@ZekaTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SampleRecordApplicationTest {

    /** Mock mvc */
    @Autowired
    protected MockMvc mockMvc;

    /**
     * Test record *
     *
     * @throws Exception exception
     * @since 1.0.0
     */
    @Test
    @Order(1)
    void test_record() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();
    }
}
