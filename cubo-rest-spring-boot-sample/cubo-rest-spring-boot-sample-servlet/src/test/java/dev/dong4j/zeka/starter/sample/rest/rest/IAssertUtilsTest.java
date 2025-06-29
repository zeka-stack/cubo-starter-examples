package dev.dong4j.zeka.starter.sample.rest.rest;

import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.form.LoginForm;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:19
 * @since 1.0.0
 */
@Slf4j
class IAssertUtilsTest {

    /**
     * Test - expect exception
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        assertThrows(Exception.class, () -> {
            ArgumentCodeEnum.BAD_XXX_TYPE.notNull(null, "dong4j");
        });
    }

    /**
     * Test 1 - expect exception
     *
     * @since 1.0.0
     */
    @Test
    void test1() {
        assertThrows(Exception.class, () -> {
            ArgumentCodeEnum.PARAM_VERIFY_ERROR.notBlank("", "手机号不能为空");
        });
    }

    /**
     * Test 2 - expect exception
     *
     * @since 1.0.0
     */
    @Test
    void test2() {
        assertThrows(Exception.class, () -> {
            ArgumentCodeEnum.PARAM_VERIFY_ERROR.notBlank("", "用户名不能为空");
        });
    }

    /**
     * Test 4 - should not throw exception
     *
     * @throws IOException io exception
     * @since 1.0.0
     */
    @Test
    void test4() throws IOException {
        String json = "{\"username\":\"demoData\",\"password\":\"demoData\",\"code\":\"demoData\",\"uuid\":\"demoData\"}";

        // 使用 JsonUtils 反序列化
        LoginForm parse = JsonUtils.parse(json, LoginForm.class);

        // 可选：添加断言验证字段值是否正确
        Assertions.assertEquals("demoData", parse.getUsername());
        Assertions.assertEquals("demoData", parse.getPassword());
        Assertions.assertEquals("demoData", parse.getCode());
        Assertions.assertEquals("demoData", parse.getUuid());
    }
}
