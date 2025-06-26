package dev.dong4j.zeka.starter.sample.{{name}};

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
 * @date {{date}}
 * @since 1.0.0
 */
@Slf4j
@RunningType(ApplicationType.SERVICE)
@SpringBootApplication
public class Sample{{Name}}Application extends ZekaStarter {
}
