package dev.dong4j.zeka.starter.sample.mybatis.single.entity.dto;

import dev.dong4j.zeka.kernel.common.base.BaseDTO;
import dev.dong4j.zeka.kernel.common.enums.DeletedEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

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
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO<Long> {
    /** serialVersionUID */
    private static final long serialVersionUID = -1618078634011450972L;
    /** Name */
    private String name;
    /** Age */
    private Integer age;
    /** Email */
    private String email;
    /** Deleted */
    private DeletedEnum deleted;

}
