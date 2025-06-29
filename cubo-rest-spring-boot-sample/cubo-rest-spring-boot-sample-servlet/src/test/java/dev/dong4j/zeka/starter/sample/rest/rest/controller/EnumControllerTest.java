package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.dong4j.zeka.kernel.common.api.BaseCodes;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.enums.UserStatusEnum;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.po.EnumEntity;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.CollectionUtils;

/**
 * <p>Description: 枚举参数序列化/反序列化测试 </p>
 * 发序列化匹配顺序: value > name > 枚举下标
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 14:47
 * @since 1.0.0
 */
class EnumControllerTest extends Chapter22ApplicationTest {

    /**
     * 实体序列化测试,
     * 实体中包含枚举字段, 将会被序列化为 json 格式
     *
     * @throws Exception exception
     * @see EnumController#convert_1_get() EnumController#convert_1_get()EnumController#convert_1_get()
     * @since 1.0.0
     */
    @Test
    @Order(1)
    void test_convert_1_get() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/enum/convert_1"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<EnumEntity> result = JsonUtils.parse(json, new TypeReference<Result<EnumEntity>>() {
        });

        Assertions.assertEquals("dong4j", result.getData().getName());
        Assertions.assertEquals(UserStatusEnum.CHECK_FAILED, result.getData().getStatus());

        List<UserStatusEnum> expectedLines = new ArrayList<UserStatusEnum>() {
            private static final long serialVersionUID = -1184899275397105431L;

            {
                this.add(UserStatusEnum.CHECKED);
                this.add(UserStatusEnum.CHECKING);
            }
        };
        Assertions.assertIterableEquals(expectedLines, result.getData().getStatusList());

        Assertions.assertEquals(UserStatusEnum.CHECKED, result.getData().getStatusMap().get("xxx"));
    }

    /**
     * 枚举序列化
     *
     * @throws Exception exception
     * @see EnumController#convert_1_post() EnumController#convert_1_post()EnumController#convert_1_post()
     * @since 1.0.0
     */
    @Test
    @Order(2)
    void test_convert_1_post() throws Exception {
        this.invoke(null, HttpMethod.POST, "/enum/convert_1", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * 接收不到参数
     *
     * @throws Exception exception
     * @see EnumController#convert_2_get EnumController#convert_2_getEnumController#convert_2_get
     * @since 1.0.0
     */
    @Test
    @Order(3)
    void test_convert_2_get() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/enum/convert_2"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<EnumEntity> result = JsonUtils.parse(json, new TypeReference<Result<EnumEntity>>() {
        });

        Assertions.assertEquals("dong4j", result.getData().getName());
        Assertions.assertNull(result.getData().getStatus());
        Assertions.assertTrue(CollectionUtils.isEmpty(result.getData().getStatusList()));
        Assertions.assertTrue(CollectionUtils.isEmpty(result.getData().getStatusMap()));
    }

    /**
     * 通过 value 字段绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_post EnumController#convert_2_postEnumController#convert_2_post
     * @since 1.0.0
     */
    @Test
    @Order(4)
    void test_convert_2_post_value() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("value", 5);
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.POST, "/enum/convert_2", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * 通过 name() 绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_post EnumController#convert_2_postEnumController#convert_2_post
     * @since 1.0.0
     */
    @Test
    @Order(5)
    void test_convert_2_post_name() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("value", "CHECK_FAILED");
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.POST, "/enum/convert_2", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * 通过 ordinal() 绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_post EnumController#convert_2_postEnumController#convert_2_post
     * @since 1.0.0
     */
    @Test
    @Order(6)
    void test_convert_2_post_ordinal() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        // 下标为 2 的枚举
        objectNode.put("value", 2);
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.POST, "/enum/convert_2", null);
    }

    /**
     * 通过 value 字段绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_put EnumController#convert_2_putEnumController#convert_2_put
     * @since 1.0.0
     */
    @Test
    @Order(7)
    void test_convert_2_put_value() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("value", 5);
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.PUT, "/enum/convert_2", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * 通过 name() 绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_put EnumController#convert_2_putEnumController#convert_2_put
     * @since 1.0.0
     */
    @Test
    @Order(8)
    void test_convert_2_put_name() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        objectNode.put("value", "CHECK_FAILED");
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.PUT, "/enum/convert_2", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * 通过 ordinal() 绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_put EnumController#convert_2_putEnumController#convert_2_put
     * @since 1.0.0
     */
    @Test
    @Order(9)
    void test_convert_2_put_ordinal() throws Exception {
        ObjectNode objectNode = JsonUtils.getCopyMapper().createObjectNode();
        // 下标为 2 的枚举
        objectNode.put("value", 2);
        byte[] body = JsonUtils.toJsonAsBytes(objectNode);

        this.invoke(body, HttpMethod.PUT, "/enum/convert_2", null);
    }

    /**
     * 通过 value 字段绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_patch EnumController#convert_2_patchEnumController#convert_2_patch
     * @since 1.0.0
     */
    @Test
    @Order(10)
    void test_convert_2_patch_value() throws Exception {
        String params = "status=5";
        this.invoke(params.getBytes(), HttpMethod.PATCH, "/enum/convert_2", UserStatusEnum.CHECK_FAILED, MediaType.APPLICATION_FORM_URLENCODED);
    }

    /**
     * 通过 name() 绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_patch EnumController#convert_2_patchEnumController#convert_2_patch
     * @since 1.0.0
     */
    @Test
    @Order(11)
    void test_convert_2_patch_name() throws Exception {
        String params = "status=CHECK_FAILED";
        this.invoke(params.getBytes(), HttpMethod.PATCH, "/enum/convert_2", UserStatusEnum.CHECK_FAILED, MediaType.APPLICATION_FORM_URLENCODED);
    }

    /**
     * 通过 ordinal() 绑定枚举
     *
     * @throws Exception exception
     * @see EnumController#convert_2_patch EnumController#convert_2_patchEnumController#convert_2_patch
     * @since 1.0.0
     */
    @Test
    @Order(12)
    void test_convert_2_patch_ordinal() throws Exception {
        String params = "status=2";
        this.invoke(params.getBytes(), HttpMethod.PATCH, "/enum/convert_2", null, MediaType.APPLICATION_FORM_URLENCODED);
    }

    /**
     * 测试 get 绑定枚举参数
     *
     * @throws Exception exception
     * @see EnumController#convert_3 EnumController#convert_3
     * @since 1.0.0
     */
    @Test
    @Order(13)
    void test_convert_3_value() throws Exception {
        this.invoke(null, HttpMethod.GET, "/enum/convert_3?status=5", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * 测试 get 绑定枚举参数
     *
     * @throws Exception exception
     * @see EnumController#convert_3 EnumController#convert_3
     * @since 1.0.0
     */
    @Test
    @Order(14)
    void test_convert_3_name() throws Exception {
        this.invoke(null, HttpMethod.GET, "/enum/convert_3?status=CHECK_FAILED", UserStatusEnum.CHECK_FAILED);
    }

    /**
     * 测试 get 绑定枚举参数
     *
     * @throws Exception exception
     * @see EnumController#convert_3 EnumController#convert_3
     * @since 1.0.0
     */
    @Test
    @Order(15)
    void test_convert_3_ordinal() throws Exception {
        this.invoke(null, HttpMethod.GET, "/enum/convert_3?status=2", null);
    }

    /**
     * 多参数绑定
     *
     * @throws Exception exception
     * @since 1.0.0
     */
    @Test
    @Order(16)
    void test_convert_4() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/enum/convert_4?status=5&name=dong4j"))
            // 添加断言
            .andExpect(MockMvcResultMatchers.status().isOk())
            // 添加执行
            .andDo(MockMvcResultHandlers.print())
            // 添加返回
            .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Result<EnumEntity> result = JsonUtils.parse(json, new TypeReference<Result<EnumEntity>>() {
        });

        Assertions.assertEquals("dong4j", result.getData().getName());
        Assertions.assertEquals(UserStatusEnum.CHECK_FAILED, result.getData().getStatus());
        Assertions.assertTrue(CollectionUtils.isEmpty(result.getData().getStatusList()));
        Assertions.assertTrue(CollectionUtils.isEmpty(result.getData().getStatusMap()));
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
    private void invoke(byte[] body, HttpMethod method, String urlTemplate, UserStatusEnum statusEnum, @NotNull MediaType... contentType) throws Exception {
        BaseCodes.PARAM_VERIFY_ERROR.isTrue(contentType.length <= 1, "contentType.length error");

        MediaType finalContentType = Arrays.isNullOrEmpty(contentType) ? MediaType.APPLICATION_JSON : contentType[0];

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
