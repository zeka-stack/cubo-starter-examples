package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.constant.ConfigKey;
import dev.dong4j.zeka.kernel.common.util.ThreadUtils;
import dev.dong4j.zeka.kernel.common.util.Tools;
import dev.dong4j.zeka.starter.rest.ServletController;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: 测试几种热部署方式 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.06.10 22:39
 * @since 1.5.0
 */
@Slf4j
@RestController
public class HotReloadController extends ServletController {
    /** Environment */
    @Resource
    private Environment environment;

    /**
     * debug 模式下修改方法体逻辑后编辑此源码即可生效, 只对方法体修改生成, 不支持新增 method 等
     *
     * @since 1.5.0
     */
    @GetMapping("hot")
    public void hotswap() {
        Tools.repeat(Integer.MAX_VALUE, () -> {
            log.info("hot-xxxx");
            ThreadUtils.sleep(2000);
        });
    }

    /**
     * 使用 jrebel 热更新, 支持新增方法
     *
     * @since 1.5.0
     */
    @GetMapping("hot-jrebel")
    public void jrebel() {
        Tools.repeat(Integer.MAX_VALUE, () -> {
            log.info("jrebel");
            ThreadUtils.sleep(2000);
        });
    }

    /**
     * Springloaded
     * jvm:
     * -noverify
     * -javaagent:/Users/dong4j/Downloads/springloaded-1.2.8.RELEASE.jar
     *
     * @see "https://github.com/spring-projects/spring-loaded"
     * @since 1.5.0
     */
    @GetMapping("springloaded")
    public void springloaded() {
        Tools.repeat(Integer.MAX_VALUE, () -> {
            log.info("springloadedxxxxcccc" + this.environment.getProperty(ConfigKey.SERVICE_VERSION));
            ThreadUtils.sleep(2000);
        });
    }

    /**
     * Hotswapagent
     * jvm:
     * -XXaltjvm=dcevm
     * -javaagent:/Users/dong4j/Downloads/hotswap-agent-1.4.1.jar
     *
     * @see "https://github.com/HotswapProjects/HotswapAgent"
     * @since 1.5.0
     */
    @GetMapping("hotswapagent")
    public void hotswapagent() {
        Tools.repeat(Integer.MAX_VALUE, () -> {
            log.info("hotswapagent" + this.environment.getProperty(ConfigKey.SERVICE_VERSION));
            ThreadUtils.sleep(2000);
        });
    }
}
