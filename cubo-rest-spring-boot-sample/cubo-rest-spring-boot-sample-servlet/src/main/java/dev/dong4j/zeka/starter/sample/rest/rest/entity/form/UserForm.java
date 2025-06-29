package dev.dong4j.zeka.starter.sample.rest.rest.entity.form;


import dev.dong4j.zeka.starter.sample.rest.rest.entity.enums.MatchModeEnum;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.enums.UserStatusEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:09
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 3457453077473375609L;

    /** Name */
    @NotNull(message = "名称为必填项")
    @Size(max = 20)
    private String name;
    /** Age */
    @Max(value = 150, message = "最大年龄不能大于 150")
    @Min(value = 1, message = "最小年龄要大于 0")
    private Integer age;
    /** Address */
    @NotNull(message = "地址为必填项")
    private String address;
    /** Email */
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "邮箱格式错误")
    private String email;

    /** Date */
    private Date date;

    /** Status */
    private UserStatusEnum status;
    /** Match mode */
    private MatchModeEnum matchMode;
    /** Match mode list */
    private List<MatchModeEnum> matchModeList;
    /** User status list */
    private List<UserStatusEnum> userStatusList;
}
