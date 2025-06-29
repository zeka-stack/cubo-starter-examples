package dev.dong4j.zeka.starter.sample.rest.rest.entity.form;

import dev.dong4j.zeka.kernel.validation.constraints.Date;
import dev.dong4j.zeka.kernel.validation.constraints.Json;
import dev.dong4j.zeka.kernel.validation.constraints.Phone;
import dev.dong4j.zeka.kernel.validation.constraints.VehicleNumber;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.08.30 18:23
 * @since 1.6.0
 */
@Data
@Builder
@Valid
public class TestForm {
    /** serialVersionUID */
    private static final long serialVersionUID = -5274383672719713886L;
    /** Date */
    @Date
    private String date;
    /** Json */
    @Json
    private String json;
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
    /** Plate no */
    @VehicleNumber
    private String plateNo;
}
