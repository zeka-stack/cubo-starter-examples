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
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 20:54
 * @since 1.0.0
 */
@Slf4j
class ResutControllerTest extends Chapter22ApplicationTest {

    /**
     * Void result
     *
     * @since 1.0.0
     */
    @Test
    void voidResult() {
        this.invoke("/result_void_1");
    }

    /**
     * Void result 2
     *
     * @since 1.0.0
     */
    @Test
    void voidResult_2() {
        this.invoke("/result_void_2");
    }

    /**
     * String result
     *
     * @since 1.0.0
     */
    @Test
    void stringResult() {
        this.invoke("/result_string");
    }

    /**
     * String array result
     *
     * @since 1.0.0
     */
    @Test
    void stringArrayResult() {
        this.invoke("/result_string_array");
    }

    /**
     * Boolean result
     *
     * @since 1.0.0
     */
    @Test
    void booleanResult() {
        this.invoke("/result_boolean");
    }

    /**
     * Status result
     *
     * @since 1.0.0
     */
    @Test
    void statusResult() {
        this.invoke("/result_status");
    }

    /**
     * Boolean array result
     *
     * @since 1.0.0
     */
    @Test
    void booleanArrayResult() {
        this.invoke("/result_boolean_array");
    }

    /**
     * Integer result
     *
     * @since 1.0.0
     */
    @Test
    void integerResult() {
        this.invoke("/result_integet");
    }

    /**
     * Integer array result
     *
     * @since 1.0.0
     */
    @Test
    void integerArrayResult() {
        this.invoke("/result_integer_array");
    }

    /**
     * Long result
     *
     * @since 1.0.0
     */
    @Test
    void longResult() {
        this.invoke("/result_long");
    }

    /**
     * Logng array result
     *
     * @since 1.0.0
     */
    @Test
    void logngArrayResult() {
        this.invoke("/result_long_array");
    }

    /**
     * Byte result
     *
     * @since 1.0.0
     */
    @Test
    void byteResult() {
        this.invoke("/result_byte");
    }

    /**
     * Byte array result
     *
     * @since 1.0.0
     */
    @Test
    void byteArrayResult() {
        this.invoke("/result_byte_array");
    }

    /**
     * Date result
     *
     * @since 1.0.0
     */
    @Test
    void dateResult() {
        this.invoke("/result_date");
    }

    /**
     * Json node result
     *
     * @since 1.0.0
     */
    @Test
    void jsonNodeResult() {
        this.invoke("/result_json_1");
    }

    /**
     * Object node result
     *
     * @since 1.0.0
     */
    @Test
    void objectNodeResult() {
        this.invoke("/result_json_2");
    }

    /**
     * User result
     *
     * @since 1.0.0
     */
    @Test
    void userResult() {
        this.invoke("/result_object");
    }

    /**
     * List result
     *
     * @since 1.0.0
     */
    @Test
    void listResult() {
        this.invoke("/result_list_1");
    }

    /**
     * List user result
     *
     * @since 1.0.0
     */
    @Test
    void listUserResult() {
        this.invoke("/result_list_2");
    }

    /**
     * Map result
     *
     * @since 1.0.0
     */
    @Test
    void mapResult() {
        this.invoke("/result_map_1");
    }

    /**
     * User map result
     *
     * @since 1.0.0
     */
    @Test
    void userMapResult() {
        this.invoke("/result_map_2");
    }

    /**
     * Sets result
     */
    @Test
    void setResult() {
        this.invoke("/result_set_1");
    }

    /**
     * Sets user result
     */
    @Test
    void setUserResult() {
        this.invoke("/result_set_2");
    }

    /**
     * Error result
     *
     * @since 1.0.0
     */
    @Test
    void errorResult() {
        this.invoke("/error_1");
    }

    /**
     * Code result
     *
     * @since 1.0.0
     */
    @Test
    void codeResult() {
        this.invoke("/error_2");
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
