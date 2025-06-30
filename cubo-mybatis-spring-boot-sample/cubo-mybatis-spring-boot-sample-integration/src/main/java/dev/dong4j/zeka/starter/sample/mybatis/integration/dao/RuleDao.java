package dev.dong4j.zeka.starter.sample.mybatis.integration.dao;

import dev.dong4j.zeka.starter.mybatis.base.BaseDao;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.Rule;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: 解析规则 Dao 接口  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:06
 * @since 1.0.0
 */
@Mapper
public interface RuleDao extends BaseDao<Rule> {

}
