package dev.dong4j.zeka.starter.sample.logsystem.service;

import dev.dong4j.zeka.starter.logsystem.entity.ApiLog;
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
public class ApiLogStorageService implements ILogStorage<ApiLog> {

    /**
     * Save boolean
     *
     * @param logging logging
     * @return the boolean
     * @since 1.0.0
     */
    @Override
    public boolean save(ApiLog logging) {
        log.warn("存储 API 日志: [{}]", logging);
        return true;
    }
}
