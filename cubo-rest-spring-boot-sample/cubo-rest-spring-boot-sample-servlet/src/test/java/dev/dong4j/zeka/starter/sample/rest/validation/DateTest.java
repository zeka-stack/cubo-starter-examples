package dev.dong4j.zeka.starter.sample.rest.validation;

import dev.dong4j.zeka.kernel.validation.constraints.Date;
import dev.dong4j.zeka.kernel.validation.util.BeanValidator;
import dev.dong4j.zeka.starter.sample.rest.SampleRestApplicationTest;
import java.io.Serializable;
import java.util.Map;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.2.3
 * @email "mailto:dong4j@gmail.com"
 * @date 2019.12.27 13:19
 * @since 1.0.0
 */
@Slf4j
class DateTest extends SampleRestApplicationTest {

    /**
     * 只使用 @Date , 可以为空
     *
     * @since 1.0.0
     */
    @Test
    void test_1() {
        try {
            Map<String, String> validateobject = BeanValidator.validateobject(TestForm1.builder().date("").build());
            if (validateobject != null && !validateobject.isEmpty()) {
                for (Map.Entry<String, String> entry : validateobject.entrySet()) {
                    log.error("{}->{}", entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.2.3
     * @email "mailto:dong4j@gmail.com"
     * @date 2019.12.27 13:25
     * @since 1.0.0
     */
    @Data
    @Builder
    private static class TestForm1 implements Serializable {
        /** serialVersionUID */
        private static final long serialVersionUID = -5274383672719713886L;
        /** Date */
        @Date
        private String date;
    }

    /**
     * 时间字段不能为空
     *
     * @since 1.0.0
     */
    @Test
    void test_2() {
        try {
            Map<String, String> validateobject = BeanValidator.validateobject(TestForm2.builder().date("").build());
            if (validateobject != null && !validateobject.isEmpty()) {
                for (Map.Entry<String, String> entry : validateobject.entrySet()) {
                    log.error("{}->{}", entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.2.3
     * @email "mailto:dong4j@gmail.com"
     * @date 2019.12.27 13:25
     * @since 1.0.0
     */
    @Data
    @Builder
    private static class TestForm2 implements Serializable {
        /** serialVersionUID */
        private static final long serialVersionUID = -5274383672719713886L;
        /** Date */
        @Date
        @NotBlank(message = "时间不能为空")
        private String date;
    }

    /**
     * 时间格式错误
     *
     * @since 1.0.0
     */
    @Test
    void test_3() {
        try {
            Map<String, String> validateobject = BeanValidator.validateobject(TestForm3.builder().date("2020-10-10").build());
            if (validateobject != null && !validateobject.isEmpty()) {
                for (Map.Entry<String, String> entry : validateobject.entrySet()) {
                    log.error("{}->{}", entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 时间格式正确
     *
     * @since 1.0.0
     */
    @Test
    void test_4() {
        try {
            Map<String, String> validateobject = BeanValidator.validateobject(TestForm3.builder().date("2020-10-10 10:00:00").build());
            if (validateobject != null && !validateobject.isEmpty()) {
                for (Map.Entry<String, String> entry : validateobject.entrySet()) {
                    log.error("{}->{}", entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.2.3
     * @email "mailto:dong4j@gmail.com"
     * @date 2019.12.27 13:25
     * @since 1.0.0
     */
    @Data
    @Builder
    private static class TestForm3 implements Serializable {
        /** serialVersionUID */
        private static final long serialVersionUID = -5274383672719713886L;
        /** Date */
        @Date
        private String date;
    }
}
