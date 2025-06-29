package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.constant.BasicConstant;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.05.08 16:58
 * @since 1.9.0
 */
class ResponseWriteControllerTest extends Chapter22ApplicationTest {

    /**
     * Test 1
     *
     * @throws Exception exception
     * @see ResponseWriteController#test1()
     * @since 1.8.0
     */
    @Test
    void test1() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test1");

        String result = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals("<script></script>", result);
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.TEXT_HTML));
    }

    /**
     * Test 2
     *
     * @see ResponseWriteController#test2()
     * @since 1.8.0
     */
    @Test
    void test2() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test2");

        String json = mvcResult.getResponse().getContentAsString();
        Result<?> result = JsonUtils.parse(json, Result.class);

        Assertions.assertEquals("<script></script>", ((Map<?, ?>) result.getData()).get(BasicConstant.RESULT_WRAPPER_VALUE_KEY));
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.APPLICATION_JSON));
    }

    /**
     * Test 3
     *
     * @see ResponseWriteController#test3()
     * @since 1.8.0
     */
    @Test
    void test3() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test3");

        String result = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals("<script></script>", result);
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.TEXT_HTML));
    }

    /**
     * Test 4
     *
     * @see ResponseWriteController#test4()
     * @since 1.8.0
     */
    @Test
    void test4() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test4");

        String result = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals("<script></script>", result);
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.APPLICATION_XML));
    }

    /**
     * Test 5
     *
     * @see ResponseWriteController#test5()
     * @since 1.8.0
     */
    @Test
    void test5() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test5");

        String json = mvcResult.getResponse().getContentAsString();
        Result<?> result = JsonUtils.parse(json, Result.class);

        Assertions.assertEquals("<script></script>", ((Map<?, ?>) result.getData()).get(BasicConstant.RESULT_WRAPPER_VALUE_KEY));
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.APPLICATION_JSON));
    }

    /**
     * Test 6
     *
     * @see ResponseWriteController#test6()
     * @since 1.8.0
     */
    @Test
    void test6() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test6");

        String json = mvcResult.getResponse().getContentAsString();

        Assertions.assertTrue(json.startsWith("{\"aa\":\"bb\"}"));
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.APPLICATION_JSON));
    }

    /**
     * Test 7
     *
     * @see ResponseWriteController#test7()
     * @since 1.8.0
     */
    @Test
    void test7() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test7");

        String json = mvcResult.getResponse().getContentAsString();
        Result<?> result = JsonUtils.parse(json, Result.class);

        Assertions.assertEquals("<script></script>", ((Map<?, ?>) result.getData()).get(BasicConstant.RESULT_WRAPPER_VALUE_KEY));
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.APPLICATION_JSON));
    }

    /**
     * Test 8
     *
     * @see ResponseWriteController#test8()
     * @since 1.8.0
     */
    @Test
    void test8() throws Exception {
        MvcResult mvcResult = this.getMvcResult("/wrapper/test8");

        String result = mvcResult.getResponse().getContentAsString();

        Assertions.assertEquals("<script></script>", result);
        Assertions.assertNotNull(mvcResult.getResponse().getContentType());
        Assertions.assertTrue(MediaType.parseMediaType(mvcResult.getResponse().getContentType()).equalsTypeAndSubtype(MediaType.APPLICATION_XML));
    }

    @NotNull
    private MvcResult getMvcResult(String s) throws Exception {
        return this.mockMvc.perform(MockMvcRequestBuilders.get(s))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();
    }
}
