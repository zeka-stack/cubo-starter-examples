package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.dong4j.zeka.kernel.common.api.BaseCodes;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.kernel.common.util.ResultCodeUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import org.junit.jupiter.api.Assertions;
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
 * @date 2020.03.10 13:34
 * @since 1.0.0
 */
class ExceptionControllerTest extends Chapter22ApplicationTest {

    /**
     * 注解验证测试
     *
     * @throws Exception exception
     * @see ExceptionController#test1 ExceptionController#test1
     * @since 1.0.0
     */
    @Test
    void test_exception_1() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("username", "dong4j");
        objectNode.put("password", "xxxxx");
        objectNode.put("phone", "18628362906");
        objectNode.put("code", "1234");
        objectNode.put("uuid", "4321");
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/exception/test1")
                .content(body)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<User> result = JsonUtils.parse(json, new TypeReference<Result<User>>() {
        });

        Assertions.assertEquals("dong4j", result.getData().getName());
    }

    /**
     * service 抛出异常, controller 不需要使用 try-catch
     *
     * @throws Exception exception
     * @see ExceptionController#test1 ExceptionController#test1
     * @since 1.0.0
     */
    @Test
    void test_exception_2() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("username", "dong4j");
        objectNode.put("password", "xxxxx");
        objectNode.put("phone", "18628362906");
        objectNode.put("code", "");
        objectNode.put("uuid", "4321");
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/exception/test1")
                .content(body)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<User> result = JsonUtils.parse(json, new TypeReference<Result<User>>() {
        });

        Assertions.assertEquals(ResultCodeUtils.generateCode(BaseCodes.PARAM_VERIFY_ERROR), result.getCode());
    }

    /**
     * Test exception 3 *
     *
     * @throws Exception exception
     * @see ExceptionController#test1 ExceptionController#test1
     * @since 1.0.0
     */
    @Test
    void test_exception_3() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/exception/random_exception"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<User> result = JsonUtils.parse(json, new TypeReference<Result<User>>() {
        });

        Assertions.assertNotEquals(2000, result.getCode());
    }

}
