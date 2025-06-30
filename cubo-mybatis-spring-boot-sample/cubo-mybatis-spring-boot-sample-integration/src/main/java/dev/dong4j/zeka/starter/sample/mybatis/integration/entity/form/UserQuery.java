package dev.dong4j.zeka.starter.sample.mybatis.integration.entity.form;

import dev.dong4j.zeka.kernel.common.base.BaseQuery;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.GenderEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.UserStatusEnum;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.09.30 10:31
 * @since 1.6.0
 */
@Data
@SuperBuilder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "查询条件")
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQuery<Long> {

    private static final long serialVersionUID = 4319745799007311954L;
    /** 用户电话号码 */
    private String phone;
    /** 用户名 */
    private String userName;
    /** 姓名 */
    private String nickName;
    /** 公司名称 */
    private String companyName;
    /** 用户邮箱 */
    private String email;
    /** 用户状态:0: 未审核, 1: 审核中, 2: 审核未通过, 3: 已锁定, 4: 正常 */
    private UserStatusEnum status;
    /** 性别枚举 */
    private GenderEnum gender;
}
