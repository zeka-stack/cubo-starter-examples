package dev.dong4j.zeka.starter.sample.rest.rest.service;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2023.04.24 23:24
 * @since x.x.x
 */
@Slf4j
@Service
public class AsyncTest {
    @Resource
    private ApplicationContext applicationContext;

    public void test1() {
        applicationContext.getBean(AsyncTest.class).test2();
    }

    @Async
    public void test2() {
        log.info("xxxx");
    }
}
