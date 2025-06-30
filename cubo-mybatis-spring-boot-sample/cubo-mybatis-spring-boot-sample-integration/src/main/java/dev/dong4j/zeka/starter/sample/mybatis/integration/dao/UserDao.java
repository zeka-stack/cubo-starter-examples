package dev.dong4j.zeka.starter.sample.mybatis.integration.dao;

import dev.dong4j.zeka.starter.mybatis.base.BaseDao;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: 用户信息表 Dao 接口  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2019.12.24 15:43
 * @since 1.0.0
 */
@Mapper
public interface UserDao extends BaseDao<User> {

}
