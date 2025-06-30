package dev.dong4j.zeka.starter.sample.mybatis.single.entity.po;

import dev.dong4j.zeka.kernel.common.enums.DeleteEnum;
import dev.dong4j.zeka.starter.mybatis.base.BasePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>Description: 用户实体对应表 user </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.05 06:19
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BasePO<Long, User> {
    /** serialVersionUID */
    private static final long serialVersionUID = -1618078634011450972L;
    /** Name */
    private String name;
    /** Age */
    private Integer age;
    /** Email */
    private String email;
    /** Deleted */
    private DeleteEnum deleted;

}
