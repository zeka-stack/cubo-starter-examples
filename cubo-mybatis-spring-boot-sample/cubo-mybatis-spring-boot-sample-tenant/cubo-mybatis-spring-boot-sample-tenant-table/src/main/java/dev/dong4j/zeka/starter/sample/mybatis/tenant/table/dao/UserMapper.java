package dev.dong4j.zeka.starter.sample.mybatis.tenant.table.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.dong4j.zeka.starter.sample.mybatis.tenant.table.po.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * MP 支持不需要 UserMapper.xml 这个模块演示内置 CRUD 咱们就不要 XML 部分了
 * </p>
 *
 * @author hubin
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.22 19:49
 * @since 2018 -08-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * Select all list
     *
     * @return the list
     * @since 1.0.0
     */
    List<User> selectAll();

    /**
     * Update
     *
     * @since 1.0.0
     */
    void update();

    /**
     * Delete
     *
     * @since 1.0.0
     */
    void delete();

}
