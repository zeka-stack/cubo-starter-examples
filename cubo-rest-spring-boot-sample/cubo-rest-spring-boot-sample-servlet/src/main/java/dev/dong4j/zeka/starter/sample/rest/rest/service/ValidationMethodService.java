package dev.dong4j.zeka.starter.sample.rest.rest.service;

import dev.dong4j.zeka.kernel.validation.util.ValidatorUtils;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.form.TestForm;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.08.30 18:42
 * @since 1.6.0
 */
@Slf4j
@Validated
@Service
public class ValidationMethodService {

    /**
     * Test
     *
     * @param form form
     * @since 1.6.0
     */
    public void test(TestForm form) {
        ValidatorUtils.validateResultProcessWithException(form);
        log.info("{}", form);
    }

    /**
     * Test 2
     *
     * @param account account
     * @since 1.6.0
     */
    public void test2(@Length(min = 6, max = 20) @NotNull String account) {
        log.info("{}", account);
    }

}
