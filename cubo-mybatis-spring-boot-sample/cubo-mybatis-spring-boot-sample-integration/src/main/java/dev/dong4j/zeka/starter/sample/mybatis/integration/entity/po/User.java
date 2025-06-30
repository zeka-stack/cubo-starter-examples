package dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import dev.dong4j.zeka.starter.mybatis.base.BaseExtendPO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.GenderEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>Description: 用户信息表 实体类  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:08
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends BaseExtendPO<Long, User> {

    /** PHONE */
    public static final String PHONE = "phone";
    /** USER_NAME */
    public static final String USER_NAME = "user_name";
    /** NICK_NAME */
    public static final String NICK_NAME = "nick_name";
    /** COMPANY_NAME */
    public static final String COMPANY_NAME = "company_name";
    /** PASSWORD */
    public static final String PASSWORD = "password";
    /** SALT */
    public static final String SALT = "salt";
    /** API_KEY */
    public static final String API_KEY = "api_key";
    /** SECRET_KEY */
    public static final String SECRET_KEY = "secret_key";
    /** EMAIL */
    public static final String EMAIL = "email";
    /** STATUS */
    public static final String STATUS = "status";
    /** GENDER */
    public static final String GENDER = "gender";
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
    /** 密码 */
    private String password;
    /** 密码加密盐值 */
    private String salt;
    /** open api key */
    private String apiKey;
    /** open api secret key */
    private String secretKey;
    /** 用户邮箱 */
    private String email;
    /** 用户状态:0: 未审核, 1: 审核中, 2: 审核未通过, 3: 已锁定, 4: 正常 */
    private UserStatusEnum status;
    /** 性别枚举 */
    private GenderEnum gender;
}
