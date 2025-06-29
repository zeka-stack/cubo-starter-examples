package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
 * @date 2020.03.10 12:14
 * @since 1.0.0
 */
@Slf4j
class ResponseWrapperControllerTest extends Chapter22ApplicationTest {

    /**
     * Test *
     *
     * @throws Exception exception
     * @see ResponseWrapperController#test1() ResponseWrapperController#test1()
     * @since 1.0.0
     */
    @Test
    void test_wrapper() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/wrapper/xxx"))
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
     * Test no wrapper *
     *
     * @throws Exception exception
     * @see ResponseWrapperController#test2() ResponseWrapperController#test2()
     * @since 1.0.0
     */
    @Test
    void test_no_wrapper() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/wrapper/yyy"))
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
     * Test exveption *
     *
     * @throws Exception exception
     * @see ResponseWrapperController#test3() ResponseWrapperController#test3()
     * @since 1.0.0
     */
    @Test
    void test_exception() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/wrapper/exception"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<?> result = JsonUtils.parse(json, Result.class);

        Assertions.assertTrue(result.isFail());
    }

    /**
     * Test void wrapper *
     *
     * @throws Exception exception
     * @see ResponseWrapperController#test4() ResponseWrapperController#test4()
     * @since 1.0.0
     */
    @Test
    void test_void_wrapper() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/wrapper/void"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<?> result = JsonUtils.parse(json, Result.class);

        Assertions.assertEquals("2000", result.getCode());
    }
}
