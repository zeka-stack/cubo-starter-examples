package dev.dong4j.zeka.starter.sample.rest.rest.service;

import dev.dong4j.zeka.starter.sample.rest.rest.Chapter22ApplicationTest;
import dev.dong4j.zeka.starter.sample.rest.rest.entity.form.TestForm;
import javax.annotation.Resource;
import javax.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.09.17 17:52
 * @since 1.6.0
 */
@Slf4j
class ValidationMethodServiceTest extends Chapter22ApplicationTest {
    /** Validation method service */
    @Resource
    private ValidationMethodService validationMethodService;

    /**
     * Test 1
     *
     * @since 1.6.0
     */
    @Test
    void test_1() {
        TestForm form = TestForm.builder()
            .date("2020-10-10 10:10:10")
            .json("{}")
            .username("d")
            .password("password")
            .phone("xxxx")
            .plateNo("川A88888")
            .build();

        ValidationException validationException = Assertions.assertThrows(ValidationException.class, () -> {
            this.validationMethodService.test(form);
        });

        log.info("{}", validationException.getMessage());
    }

    /**
     * Test 2
     *
     * @since 1.6.0
     */
    @Test
    void test_2() {

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> {
            this.validationMethodService.test2("aaa");
        });

        log.info("{}", exception.getMessage());
    }
}
