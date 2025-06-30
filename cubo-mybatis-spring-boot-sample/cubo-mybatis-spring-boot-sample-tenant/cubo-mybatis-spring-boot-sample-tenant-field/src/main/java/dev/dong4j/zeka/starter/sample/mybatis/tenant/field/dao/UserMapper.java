package dev.dong4j.zeka.starter.sample.mybatis.tenant.field.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.field.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.2.4
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.17 18:31
 * @since 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
