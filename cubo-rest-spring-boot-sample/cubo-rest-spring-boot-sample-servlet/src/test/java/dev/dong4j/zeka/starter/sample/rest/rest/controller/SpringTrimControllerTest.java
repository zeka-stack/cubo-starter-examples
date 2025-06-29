package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>Description: 字符串空白符测试 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.05.26 12:00
 * @since 1.9.0
 */
@AutoConfigureMockMvc
class SpringTrimControllerTest extends Chapter22ApplicationTest {

    /** PARAM */
    private static final String PARAM = " test ";
    /** RESULT */
    private static final String RESULT = PARAM.trim();

    /**
     * 测试 url 参数
     *
     * @throws Exception exception
     * @see SpringTrimController#urlParam(String)
     * @since 1.9.0
     */
    @Test
    void url() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/url?name=" + PARAM))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(RESULT));
    }

    /**
     * 测试 form-data 参数
     *
     * @throws Exception exception
     * @see SpringTrimController#formParam(User)
     * @since 1.9.0
     */
    @Test
    void form() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/form")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content("name=" + PARAM)
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value(RESULT));
    }

    /**
     * 测试 json body 参数
     *
     * @throws Exception exception
     * @see SpringTrimController#bodyParam(User)
     * @since 1.9.0
     */
    @Test
    void body() throws Exception {
        String json = "{\"name\":\"" + PARAM + "\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/body")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value(RESULT));
    }
}
