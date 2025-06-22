package dev.dong4j.zeka.starter.sample.launcher;

import dev.dong4j.zeka.starter.launcher.util.ClassScanner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.18 10:56
 * @since 1.0.0
 */
@Slf4j
class ClassScannerTest {

    /**
     * Test scanner
     *
     * @since 1.0.0
     */
    @Test
    void test_scanner() {
        Set<Class<?>> classes = ClassScanner.getClasses("dev.dong4j.zeka.starter.sample.launcher");

        log.info("{}", classes);
    }
}
