package dev.dong4j.zeka.starter.sample.rest;

import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.sample.rest.rest.service.AsyncTest;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

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
@EnableAsync
@SpringBootApplication
public class SampleRestApplication extends ZekaStarter {

    @Resource
    private AsyncTest asyncTest;

    @Override
    public void after() {
        asyncTest.test1();
    }
}
