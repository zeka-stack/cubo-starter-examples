package dev.dong4j.zeka.starter.sample.mybatis.integration.service;

import dev.dong4j.zeka.starter.mybatis.service.BaseService;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.User;

/**
 * <p>Description: 用户信息表 服务接口 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2019.12.24 15:42
 * @since 1.0.0
 */
public interface UserService extends BaseService<User> {

    /**
     * Transactional
     *
     * @since 1.6.0
     */
    void transactional();
}

