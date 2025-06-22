package dev.dong4j.zeka.starter.sample.logsystem;

import dev.dong4j.zeka.kernel.common.api.R;
import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.starter.logsystem.annotation.OperationLog;
import dev.dong4j.zeka.starter.logsystem.annotation.RestLog;
import dev.dong4j.zeka.starter.logsystem.enums.OperationAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
@RestController
@SpringBootApplication
public class SampleRecordApplication {

    /**
     * Main
     *
     * @param args args
     * @since 1.0.0
     */
    public static void main(String[] args) {
        // 如果使用 zeka-stack-launcher 启动应用, 则不需要此配置
        System.setProperty("spring.main.allow-bean-definition-overriding", "true");
        SpringApplication.run(SampleRecordApplication.class);
    }

    /**
     * Hello result
     *
     * @return the result
     * @since 1.0.0
     */
    @RestLog("hello")
    @OperationLog(action = OperationAction.ADD, value = "hello: #{#dateFormat(#time)}")
    @GetMapping("/hello")
    public Result<Void> hello(@RequestParam Date time) {
        return R.succeed();
    }

}
