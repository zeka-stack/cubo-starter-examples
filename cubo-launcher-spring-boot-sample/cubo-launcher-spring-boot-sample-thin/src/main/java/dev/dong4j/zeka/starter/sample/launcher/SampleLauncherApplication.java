package dev.dong4j.zeka.starter.sample.launcher;

import dev.dong4j.zeka.starter.launcher.ZekaStarter;
import dev.dong4j.zeka.starter.launcher.annotation.RunningType;
import dev.dong4j.zeka.starter.launcher.enums.ApplicationType;
import dev.dong4j.zeka.starter.launcher.event.LauncherEvent;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.25 15:57
 * @since 1.0.0
 */
@Slf4j
@RunningType(value = ApplicationType.SERVICE)
@SpringBootApplication
public class SampleLauncherApplication extends ZekaStarter {

    // region todo-dong4j : (2019年09月27日 10:30) [根据需求实现以下扩展, 可全部删除]

    /**
     * 启动前处理逻辑
     *
     * @since 1.0.0
     */
    @Override
    public void before() {
        log.info("before");
    }

    /**
     * 启动完成后处理逻辑
     *
     * @since 1.0.0
     */
    @Override
    public void after() {
        log.info("after");
    }

    /**
     * 启动完成后发送自定义事件
     *
     * @param context the context
     * @since 1.0.0
     */
    @Override
    public void publishEvent(@NotNull ConfigurableApplicationContext context) {
        // Object 替换为自定义事件实体, 需要继承 BaseEvent
        context.publishEvent(new LauncherEvent(new Object()));
    }
    // endregion
}
