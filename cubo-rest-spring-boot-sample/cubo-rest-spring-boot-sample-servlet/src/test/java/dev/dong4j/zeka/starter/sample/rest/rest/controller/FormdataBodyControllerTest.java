package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.starter.rest.support.RequestSingleParamHandlerMethodArgumentResolver;
import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>Description: FormDataBody 注解测试 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 16:40
 * @see RequestSingleParamHandlerMethodArgumentResolver
 * @since 1.0.0
 */
@Slf4j
public class FormdataBodyControllerTest extends Chapter22ApplicationTest {

    /**
     * Test param 1 *
     *
     * @throws Exception exception
     * @see FormdataBodyController#param
     * @since 1.0.0
     */
    @Test
    void test_param_1() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/form/1")
                .param("user_name", "dong4j")
                .param("pass_word", "xxxxxx")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        Exception exception = mvcResult.getResolvedException();
        Assertions.assertNull(exception);
    }
}
