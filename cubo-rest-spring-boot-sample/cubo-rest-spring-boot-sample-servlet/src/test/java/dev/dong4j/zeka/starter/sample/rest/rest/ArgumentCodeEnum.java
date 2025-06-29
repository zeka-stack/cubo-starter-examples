package dev.dong4j.zeka.starter.sample.rest.rest;

import dev.dong4j.zeka.kernel.common.assertion.BaseExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Description: 参数校验异常返回结果, 业务端扩展</p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2019.12.26 21:41
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ArgumentCodeEnum implements BaseExceptionAssert {
    /** 手机号格式错误 */
    PARAM_VERIFY_ERROR(6001, "[{}] 不能为空"),
    /** Bad xxx type argument code enum */
    BAD_XXX_TYPE(7001, "oh, [{}] is 'a' pig");

    /** 返回码 */
    private final Integer code;
    /** 返回消息 */
    private final String message;

}
