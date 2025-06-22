package dev.dong4j.zeka.starter.sample.logsystem.service;

import dev.dong4j.zeka.starter.logsystem.entity.ErrorLog;
import dev.dong4j.zeka.starter.logsystem.storage.ILogStorage;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2019.11.21 13:21
 * @since 1.0.0
 */
@Slf4j
public class ErrorLogStorageService implements ILogStorage<ErrorLog> {

    /**
     * Save boolean
     * todo-dong4j : (2019年11月20日 21:35) [使用 ES client 存入 ES]
     *
     * @param logging logging
     * @return the boolean
     * @since 1.0.0
     */
    @Override
    public boolean save(ErrorLog logging) {
        log.warn("存储错误日志: [{}]", logging);
        return false;
    }
}
