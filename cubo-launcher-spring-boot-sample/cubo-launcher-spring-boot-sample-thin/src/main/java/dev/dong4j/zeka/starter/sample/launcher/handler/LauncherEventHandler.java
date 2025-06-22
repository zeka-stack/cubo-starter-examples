package dev.dong4j.zeka.starter.sample.launcher.handler;

import dev.dong4j.zeka.kernel.common.event.BaseEventHandler;
import dev.dong4j.zeka.starter.launcher.event.LauncherEvent;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:11
 * @since 1.0.0
 */
@Slf4j
@Component
public class LauncherEventHandler extends BaseEventHandler<LauncherEvent> {

    /**
     * Handler *
     *
     * @param event event
     * @since 1.0.0
     */
    @Override
    @EventListener
    public void handler(@NotNull LauncherEvent event) {
        log.info("{}", event.getSource());
    }

}
