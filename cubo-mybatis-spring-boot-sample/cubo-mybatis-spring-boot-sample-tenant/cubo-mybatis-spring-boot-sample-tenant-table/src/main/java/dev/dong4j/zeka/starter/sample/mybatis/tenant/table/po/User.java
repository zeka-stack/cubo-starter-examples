package dev.dong4j.zeka.starter.sample.mybatis.tenant.table.po;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.23 20:02
 * @since 2018 -08-11
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = -1618078634011450972L;
    /** Id */
    private Long id;
    /** Name */
    private String name;
    /** Age */
    private Integer age;
    /** Email */
    private String email;

}
