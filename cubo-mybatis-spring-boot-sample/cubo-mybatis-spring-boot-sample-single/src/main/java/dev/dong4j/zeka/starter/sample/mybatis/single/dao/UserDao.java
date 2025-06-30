package dev.dong4j.zeka.starter.sample.mybatis.single.dao;

import dev.dong4j.zeka.starter.mybatis.base.BaseDao;
import dev.dong4j.zeka.starter.sample.mybatis.single.entity.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: MP 支持不需要 UserMapper.xml 这个模块演示内置 CRUD 咱们就不要 XML 部分了 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.05 06:19
 * @since 1.0.0
 */
@Mapper
public interface UserDao extends BaseDao<User> {

}
