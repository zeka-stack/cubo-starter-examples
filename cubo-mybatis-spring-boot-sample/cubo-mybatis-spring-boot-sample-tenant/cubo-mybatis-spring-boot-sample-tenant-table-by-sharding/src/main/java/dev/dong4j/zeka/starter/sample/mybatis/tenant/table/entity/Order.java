package dev.dong4j.zeka.starter.sample.mybatis.tenant.table.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dongshijie@gmail.com"
 * @date 2020.02.23 08:40
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_order")
public class Order implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 6033798794583726080L;
    /** Order id */
    private Long orderId;
    /** Price */
    private BigDecimal price;
    /** User id */
    private Long userId;
    /** Status */
    private String status;
}
