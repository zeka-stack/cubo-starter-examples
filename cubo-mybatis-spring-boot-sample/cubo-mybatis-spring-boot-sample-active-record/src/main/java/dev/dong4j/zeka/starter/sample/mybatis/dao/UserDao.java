package dev.dong4j.zeka.starter.sample.mybatis.dao;

import dev.dong4j.zeka.starter.mybatis.base.BaseDao;
import dev.dong4j.zeka.starter.sample.mybatis.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: 必须得有 dao</p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.18 15:24
 * @since 1.0.0
 */
@Mapper
public interface UserDao extends BaseDao<User> {

}
