package dev.dong4j.zeka.starter.sample.logsystem;

import dev.dong4j.zeka.kernel.common.context.SpringContext;
import dev.dong4j.zeka.kernel.common.util.ConfigKit;
import dev.dong4j.zeka.kernel.common.util.ThreadUtils;
import dev.dong4j.zeka.kernel.common.util.Tools;
import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.launcher.annotation.RunningType;
import dev.dong4j.zeka.starter.launcher.enums.ApplicationType;
import dev.dong4j.zeka.starter.logsystem.event.ChangeLogLevelEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashMap;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.2.4
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.25 17:09
 * @since 1.0.0
 */
@Slf4j
@RunningType(ApplicationType.SERVICE)
@EnableAutoConfiguration
public class SampleLog4j2Application extends ZekaStarter {

    static {
        ConfigKit.openDebug();
    }

    @Override
    public void run(String... args) {
        SpringContext.publishEvent(new ChangeLogLevelEvent(new HashMap<String, String>(2) {
            private static final long serialVersionUID = 8845091785801800828L;

            {
                this.put("root", "debug");
                this.put("dev.dong4j.zeka.starter.sample.logsystem", "debug");
            }
        }));

        ThreadUtils.submit(1, () -> {
            Tools.repeat(Integer.MAX_VALUE, () -> {
                log.debug("大威天龙, 世尊地藏, 般若诸佛, 般若巴嘛空");
                log.info("大威天龙, 世尊地藏, 般若诸佛, 般若巴嘛空");
                log.warn("大威天龙, 世尊地藏, 般若诸佛, 般若巴嘛空");
                log.error("大威天龙, 世尊地藏, 般若诸佛, 般若巴嘛空");

                ThreadUtils.sleep(500);
            });
        }, () -> {
        });
    }

    /**
     * 在 spring 容器启动完成后执行自定义逻辑.
     *
     * @since 1.0.0
     */
    @Override
    protected void after() {
        SpringContext.publishEvent(new ChangeLogLevelEvent(new HashMap<>(0)));
    }
}
