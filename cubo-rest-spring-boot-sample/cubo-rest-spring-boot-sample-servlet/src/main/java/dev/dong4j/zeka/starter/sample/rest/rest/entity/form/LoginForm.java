package dev.dong4j.zeka.starter.sample.rest.rest.entity.form;

import dev.dong4j.zeka.kernel.validation.constraints.Phone;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.02 18:24
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "LoginForm", description = "统一登录实体")
public class LoginForm implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = -2343233251882358359L;
    /** 用户名 */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 32, message = "用户名长度限制在 4 ~ 32 位")
    private String username;
    /** 密码 */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 64, message = "密码长度限制在 6 ~ 64 位")
    private String password;
    /** Phone */
    @Phone
    private String phone;
    /** 验证码 */
    private String code;
    /** 与验证码绑定的 uuid */
    private String uuid;
}
