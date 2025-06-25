package dev.dong4j.zeka.starter.sample.messaging;

import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.launcher.annotation.RunningType;
import dev.dong4j.zeka.starter.launcher.enums.ApplicationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2025.06.25 01:12
 * @since x.x.x
 */
@Slf4j
@RunningType(ApplicationType.SERVICE)
@EnableAutoConfiguration
public class SampleRocketMQApplication extends ZekaStarter {
}
