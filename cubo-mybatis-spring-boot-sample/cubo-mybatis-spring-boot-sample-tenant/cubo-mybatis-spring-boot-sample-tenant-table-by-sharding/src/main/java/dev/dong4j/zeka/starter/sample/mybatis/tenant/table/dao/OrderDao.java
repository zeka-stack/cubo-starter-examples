package dev.dong4j.zeka.starter.sample.mybatis.tenant.table.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.23 08:21
 * @since 1.0.0
 */
@Mapper
public interface OrderDao {

    /**
     * 插入订单
     *
     * @param price  price
     * @param userId user id
     * @param status status
     * @return int int
     * @since 1.0.0
     */
    @Insert("insert into t_order(price,user_id,status)values(#{price},#{userId},#{status})")
    int insertOrder(@Param("price") BigDecimal price, @Param("userId") Long userId, @Param("status") String status);

    /**
     * 根据id列表查询订单
     *
     * @param list list
     * @return list list
     * @since 1.0.0
     */
    @Select("select" +
        " * " +
        " from t_order t " +
        " where t.order_id in " +
        " <foreach collection='list' index='index' item='id' open='(' separator=',' close=')'>" +
        " #{id} " +
        " </foreach>")
    List<Map> selectOrderbyIds(List<Long> list);

    /**
     * Select orderby id list
     *
     * @param id id
     * @return the list
     * @since 1.0.0
     */
    @Select("select" +
        " * " +
        " from t_order t " +
        " where t.order_id = #{id}")
    Map selectOrderbyId(Long id);
}
