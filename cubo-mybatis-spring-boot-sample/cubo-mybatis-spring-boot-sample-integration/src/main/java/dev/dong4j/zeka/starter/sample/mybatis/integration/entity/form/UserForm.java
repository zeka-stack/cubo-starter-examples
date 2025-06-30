package dev.dong4j.zeka.starter.sample.mybatis.integration.entity.form;

import dev.dong4j.zeka.kernel.common.base.BaseForm;
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
 * @date 2020.09.30 15:19
 * @since 1.6.0
 */
@Data
@SuperBuilder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserForm extends BaseForm<Long> {
    private static final long serialVersionUID = -474285560227382166L;
    /** Xxx */
    private String xxx;
}
