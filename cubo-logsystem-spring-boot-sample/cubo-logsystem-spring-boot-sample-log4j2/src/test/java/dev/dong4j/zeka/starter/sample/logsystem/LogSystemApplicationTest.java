package dev.dong4j.zeka.starter.sample.logsystem;

import dev.dong4j.zeka.kernel.common.context.SpringContext;
import dev.dong4j.zeka.kernel.common.util.ConfigKit;
import dev.dong4j.zeka.kernel.common.util.ThreadUtils;
import dev.dong4j.zeka.kernel.common.util.Tools;
import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.logsystem.event.ChangeLogLevelEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.03 12:59
 * @since 1.0.0
 */
@Slf4j
@ActiveProfiles("all")
@ZekaTest(classes = SampleLog4j2Application.class)
public class LogSystemApplicationTest {

    static {
        ConfigKit.openDebug();
    }

    /**
     * Test log
     *
     * @since 1.0.0
     */
    // @AfterEach
    public void test_log() {
        Tools.repeat(100000, () -> {
            log.trace("traceId");
            log.debug("debug");
            log.info("info");
            log.warn("warn");
            log.error("error");
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(3));
        });
    }

    @Test
    void test_1() {
        SpringContext.publishEvent(new ChangeLogLevelEvent(new HashMap<>()));
        ThreadUtils.join();
    }

}
