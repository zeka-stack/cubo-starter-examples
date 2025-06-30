package dev.dong4j.zeka.starter.sample.mybatis.integration.service;

import dev.dong4j.zeka.starter.mybatis.service.BaseService;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.Rule;

/**
 * <p>Description: 解析规则 服务接口 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:08
 * @since 1.0.0
 */
public interface RuleService extends BaseService<Rule> {

    /**
     * Transactional
     *
     * @since 1.6.0
     */
    void transactional();
}

