package dev.dong4j.zeka.starter.sample.mybatis.entity.po;

import dev.dong4j.zeka.starter.mybatis.base.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.18 15:23
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BasePO<Long, User> {
    /** serialVersionUID */
    private static final long serialVersionUID = 2440192254013150059L;
    /** Name */
    private String name;
    /** Age */
    private Integer age;
    /** Email */
    private String email;

}
