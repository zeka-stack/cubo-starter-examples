package dev.dong4j.zeka.starter.sample.mybatis.integration.entity.dto;

import dev.dong4j.zeka.kernel.common.base.BaseDTO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * 用户信息表数据传输对象实体类
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
public class UserDTO extends BaseDTO<Long> {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** Gender */
    private GenderEnum gender;

}

