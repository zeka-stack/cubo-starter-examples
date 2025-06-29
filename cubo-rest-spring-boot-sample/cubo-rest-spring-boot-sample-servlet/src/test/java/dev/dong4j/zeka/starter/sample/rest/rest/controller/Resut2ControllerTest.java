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
 * <p>Description: controller 返回值自动扩展 Result
 * 且 如果返回值是 基础数据类型或基础数据类型对应的 List/Set 时，Result 的 data 字段自动封装为 Map 增加 value </p>
 * 各场景测试返回内容已再单元测试方法上做备注
 *
 * @author dong4j
 * @version 1.7.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.12.04 14:04
 * @since 1.7.0
 */
@Slf4j
class Resut2ControllerTest extends Chapter22ApplicationTest {

    /**
     * String result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":"hello"},"message":"请求成功","traceId":"67c1293b49bdd484110acb80239b017a"}
     *
     * @see Resut2Controller#stringResult() Resut2Controller#stringResult()
     * @since 1.7.0
     */
    @Test
    void stringResult() {
        this.invoke("/result_string2");
    }

    /**
     * String array result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":["hello","world"]},"message":"请求成功","traceId":"4f299788e205dd8434464ea6fb1e6385"}
     *
     * @see Resut2Controller#stringArrayResult() Resut2Controller#stringArrayResult()
     * @since 1.7.0
     */
    @Test
    void stringArrayResult() {
        this.invoke("/result_string_array2");
    }

    /**
     * Boolean result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":true},"message":"请求成功","traceId":"39c9511fc6d551ac29601f41e5f89ab1"}
     *
     * @see Resut2Controller#booleanResult() Resut2Controller#booleanResult()
     * @since 1.7.0
     */
    @Test
    void booleanResult() {
        this.invoke("/result_boolean2");
    }

    /**
     * Boolean array result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":[true,false]},"message":"请求成功","traceId":"d654ce80cb04dc7887c8ea83755271b1"}
     *
     * @see Resut2Controller#booleanArrayResult() Resut2Controller#booleanArrayResult()
     * @since 1.7.0
     */
    @Test
    void booleanArrayResult() {
        this.invoke("/result_boolean_array2");
    }

    /**
     * Integer result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":1024}, "message":"请求成功","traceId":"f62cae7d0b414d908e6c28815c4643f0"}
     *
     * @see Resut2Controller#integerResult() Resut2Controller#integerResult()
     * @since 1.7.0
     */
    @Test
    void integerResult() {
        this.invoke("/result_integet2");
    }

    /**
     * Integer array result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":[1024,2048]},"message":"请求成功","traceId":"8357bf8e359a73db7becb569ea6010be"}
     *
     * @see Resut2Controller#integerArrayResult() Resut2Controller#integerArrayResult()
     * @since 1.7.0
     */
    @Test
    void integerArrayResult() {
        this.invoke("/result_integer_array2");
    }

    /**
     * Long result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":1024},"message":"请求成功","traceId":"62a54b0da1c4b5bd1b8f969567f1efe3"}
     *
     * @see Resut2Controller#longResult() Resut2Controller#longResult()
     * @since 1.7.0
     */
    @Test
    void longResult() {
        this.invoke("/result_long2");
    }

    /**
     * Logng array result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":[1024,2048]},"message":"请求成功","traceId":"85650d1914268b668e088cffdf39f960"}
     *
     * @see Resut2Controller#logngArrayResult() Resut2Controller#logngArrayResult()
     * @since 1.7.0
     */
    @Test
    void logngArrayResult() {
        this.invoke("/result_long_array2");
    }

    /**
     * Byte result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":111},"message":"请求成功","traceId":"b4c7ca69f3c040e8abecf77c82d2b9df"}
     *
     * @see Resut2Controller#byteResult() Resut2Controller#byteResult()
     * @since 1.7.0
     */
    @Test
    void byteResult() {
        this.invoke("/result_byte2");
    }

    /**
     * Byte array result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"value":[111]},"message":"请求成功","traceId":"b458eb8cb422e3cc84e5bd47c8280459"}
     *
     * @see Resut2Controller#byteArrayResult() Resut2Controller#byteArrayResult()
     * @since 1.7.0
     */
    @Test
    void byteArrayResult() {
        this.invoke("/result_byte_array2");
    }

    /**
     * List result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":["xxx","yyy"],"message":"请求成功","traceId":"a08735da9bac57e02ba0ad0c5487660c"}
     *
     * @see Resut2Controller#listResult() Resut2Controller#listResult()
     * @since 1.7.0
     */
    @Test
    void listResult() {
        this.invoke("/result_list_12");
    }

    /**
     * List user result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":[{"name":"xxx","address":"","email":"","date":""}],
     * "message":"请求成功","traceId":"b1d7bd2c75aaaa38ddf9d66be0a83a75"}
     *
     * @see Resut2Controller#listUserResult() Resut2Controller#listUserResult()
     * @since 1.7.0
     */
    @Test
    void listUserResult() {
        this.invoke("/result_list_22");
    }

    /**
     * Map result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"yyy":"bbb","xxx":"aaa"},"message":"请求成功","traceId":"19bde638c296e633501866e8e089f0ec"}
     *
     * @see Resut2Controller#mapResult() Resut2Controller#mapResult()
     * @since 1.7.0
     */
    @Test
    void mapResult() {
        this.invoke("/result_map_12");
    }

    /**
     * User map result
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":{"yyy":{"name":"yyy","address":"","email":"","date":""},
     * "xxx":{"name":"xxx","address":"","email":"","date":""}},
     * "message":"请求成功","traceId":"f9d1a1836aad8263e254b4e0ce9b98f1"}
     *
     * @see Resut2Controller#userMapResult() Resut2Controller#userMapResult()
     * @since 1.7.0
     */
    @Test
    void userMapResult() {
        this.invoke("/result_map_22");
    }

    /**
     * Sets result *
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":["yyy","xxx"],"message":"请求成功","traceId":"749470f8b858a718604b2bb47e7178ca"}
     *
     * @see Resut2Controller#setResult() Resut2Controller#setResult()
     * @since 1.7.0
     */
    @Test
    void setResult() {
        this.invoke("/result_set_12");
    }

    /**
     * Sets user result *
     * {"type":"StandardResult","code":"2000","success":true,
     * "data":[{"name":"yyy","address":"","email":"","date":""}],
     * "message":"请求成功","traceId":"e180d673a02b01fe5678c00a4504f7ff"}
     *
     * @see Resut2Controller#setUserResult() Resut2Controller#setUserResult()
     * @since 1.7.0
     */
    @Test
    void setUserResult() {
        this.invoke("/result_set_22");
    }

    /**
     * Page
     *
     * @since 1.7.0
     */
    @Test
    void page() {
        this.invoke("/result_page");
    }

    /**
     * Page 1
     *
     * @since 1.7.0
     */
    @Test
    void page1() {
        this.invoke("/result_page_1");
    }

    /**
     * Page 1
     *
     * @since 1.7.0
     */
    @Test
    void page2() {
        this.invoke("/result_page_2");
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
