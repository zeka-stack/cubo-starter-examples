package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.7.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.12.07 19:10
 * @since 1.7.0
 */
@Slf4j
class WithNoServletControllerTest extends Chapter22ApplicationTest {

    @Test
    void get() {
        this.invoke("/with_no_servlet/get");
    }

    /**
     * Invoke *
     *
     * @param urlTemplate url template
     * @since 1.0.0
     */
    @SneakyThrows
    private void invoke(String urlTemplate) {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get(urlTemplate)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        log.info("{}", mvcResult.getResponse().getContentAsString());
    }
}
