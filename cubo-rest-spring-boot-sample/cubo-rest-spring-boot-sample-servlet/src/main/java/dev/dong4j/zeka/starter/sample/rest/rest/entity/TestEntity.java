package dev.dong4j.zeka.starter.sample.rest.rest.entity;

import dev.dong4j.zeka.kernel.common.base.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.7.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.12.30 09:42
 * @since 1.7.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TestEntity extends AbstractBaseEntity<Long> {
    private String test;
}
