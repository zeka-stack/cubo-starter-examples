package dev.dong4j.zeka.starter.sample.mybatis.integration.entity.vo;

import dev.dong4j.zeka.kernel.common.base.BaseVO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.GenderEnum;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * 用户信息表视图实体类
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:06
 * @since 1.0.0
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserVO对象", description = "用户信息表")
public class UserVO extends BaseVO<Long> {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 用户电话号码 */
    private String phone;
    /** 用户名 */
    private String userName;
    /** 姓名 */
    private String nickName;
    /** 公司名称 */
    private String companyName;
    /** open api key */
    private String apiKey;
    /** open api secret key */
    private String secretKey;
    /** 用户邮箱 */
    private String email;
    /** Gender */
    private GenderEnum gender;

}
