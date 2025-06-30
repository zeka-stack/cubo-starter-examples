package dev.dong4j.zeka.starter.sample.mybatis.tenant.field.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>Description: 用户实体类 </p>
 *
 * @author dong4j
 * @version 1.2.4
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.02.17 18:31
 * @since 1.0.0
 */
@Data
@ToString
@Accessors(chain = true)
@TableName(schema = "tenant", value = "user")
public class User {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 多租户 Id
     */
    private Long tenantId;
}
