package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.dong4j.zeka.kernel.common.api.BaseCodes;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.enums.UserStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
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
 * @date 2020.03.10 18:32
 * @since 1.0.0
 */
@Slf4j
class RequestSingleParamControllerTest extends Chapter22ApplicationTest {

    /**
     * Test param 1 *
     *
     * @throws Exception exception
     * @see RequestSingleParamController#param_1 RequestSingleParamController#param_1RequestSingleParamController#param_1
     * @since 1.0.0
     */
    @Test
    void test_param_1() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("status", 5);
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/param/1")
                .content(body)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        Exception exception = mvcResult.getResolvedException();
        Assertions.assertNotNull(exception);
        Assertions.assertTrue(exception.getMessage().contains("参数校验失败"));
    }

    /**
     * Test param 2 value *
     *
     * @throws Exception exception
     * @see RequestSingleParamController#param_2(UserStatusEnum)
     * @since 1.0.0
     */
    @Test
    void test_param_2_value() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("status", 5);
        objectNode.put("name", "dong4j");
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.POST, "/param/2", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * Test param 2 name *
     *
     * @throws Exception exception
     * @see RequestSingleParamController#param_2(UserStatusEnum)
     * @since 1.0.0
     */
    @Test
    void test_param_2_name() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("status", "CHECK_FAILED");
        objectNode.put("name", "dong4j");
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.POST, "/param/2", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * Test param 2 ordinal *
     *
     * @throws Exception exception
     * @see RequestSingleParamController#param_2(UserStatusEnum)
     * @since 1.0.0
     */
    @Test
    void test_param_2_ordinal() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("status", 2);
        objectNode.put("name", "dong4j");
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.POST, "/param/2", null);
    }


    /**
     * Invoke *
     *
     * @param body        body
     * @param method      method
     * @param urlTemplate url template
     * @param contentType content type
     * @throws Exception exception
     * @since 1.0.0
     */
    private void invoke(byte[] body,
                        HttpMethod method,
                        String urlTemplate,
                        UserStatusEnum statusEnum,
                        @NotNull MediaType... contentType) throws Exception {
        BaseCodes.PARAM_VERIFY_ERROR.isTrue(contentType.length <= 1, "contentType.length error");

        MediaType finalContentType = Arrays.isNullOrEmpty(contentType) ? org.springframework.http.MediaType.APPLICATION_JSON : contentType[0];

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .request(method, urlTemplate)
                .content(body)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(finalContentType))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<UserStatusEnum> result = JsonUtils.parse(json, new TypeReference<Result<UserStatusEnum>>() {
        });

        Assertions.assertEquals(statusEnum, result.getData());
    }

}
