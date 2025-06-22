package dev.dong4j.zeka.starterl.sample.patch;

import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.launcher.annotation.RunningType;
import dev.dong4j.zeka.starter.launcher.enums.ApplicationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dongshijie@gmail.com"
 * @date 2020.05.05 19:38
 * @since 1.0.0
 */
@Slf4j
@RunningType(value = ApplicationType.SERVICE)
@EnableAutoConfiguration
public class PatchApplication extends ZekaStarter {

    static {
        log.info("patch: {}", new PatchTest());
    }
}

