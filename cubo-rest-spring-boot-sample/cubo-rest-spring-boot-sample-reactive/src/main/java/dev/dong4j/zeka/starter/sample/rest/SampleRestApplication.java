package dev.dong4j.zeka.starter.sample.rest;

import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.launcher.annotation.RunningType;
import dev.dong4j.zeka.starter.launcher.enums.ApplicationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 示例启动类
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2025.06.29 13:37
 * @since 1.0.0
 */
@Slf4j
@RunningType(ApplicationType.SERVICE)
@SpringBootApplication
public class SampleRestApplication extends ZekaStarter {
}
