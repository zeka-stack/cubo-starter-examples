package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger.web.SwaggerResource;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.7.3
 * @email "mailto:dong4j@gmail.com"
 * @date 2021.02.03 14:15
 * @since 1.7.3
 */
@Slf4j
public class ResponseAdviceTest extends Chapter22ApplicationTest {

    /**
     * 非 zeka.stack 目录下的 Controller 不自动封装为 Result
     * todo-dong4j : (2025.06.29 15:41) [测试失败]
     *
     * @throws Exception exception
     * @see ApiResourceController#swaggerResources ApiResourceController#swaggerResources
     * @since 1.7.3
     */
    @Test
    public void test_not_wrapper() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/swagger-resources"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();

        List<SwaggerResource> result = JsonUtils.parse(json, new TypeReference<List<SwaggerResource>>() {
        });

        Assertions.assertNotNull(result);
    }

    /**
     * @see ResponseWrapperControllerTest#test_wrapper()
     * @since 1.7.3
     */
    @Test
    public void test_with_wrapper() {
        // 参考另外一个测试类，这里不做重复测试
    }
}
