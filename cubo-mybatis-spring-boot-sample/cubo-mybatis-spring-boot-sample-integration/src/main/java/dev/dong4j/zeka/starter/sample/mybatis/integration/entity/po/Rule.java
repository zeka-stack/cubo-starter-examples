package dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import dev.dong4j.zeka.kernel.common.enums.EnableEnum;
import dev.dong4j.zeka.starter.mybatis.base.BaseExtendPO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.DispatchModeEnum;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.MatchModeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>Description: 解析规则 实体类  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:08
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("rule")
public class Rule extends BaseExtendPO<Long, Rule> {

    /** IP_FROM */
    public static final String IP_FROM = "ip_from";
    /** IP_TO */
    public static final String IP_TO = "ip_to";
    /** MATCH_MODE */
    public static final String MATCH_MODE = "match_mode";
    /** NAME */
    public static final String NAME = "name";
    /** PRIORITY */
    public static final String PRIORITY = "priority";
    /** ENABLED */
    public static final String ENABLED = "enabled";
    /** DISPATCH_MODE */
    public static final String DISPATCH_MODE = "dispatch_mode";
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** IP范围开始地址 */
    private Long ipFrom;
    /** IP范围结束地址 */
    private Long ipTo;
    /** 域名匹配模式 */
    private MatchModeEnum matchMode;
    /** 匹配的域名 */
    private String name;
    /** 匹配优先级 */
    private Integer priority;
    /** 是否启用 */
    private EnableEnum enabled;
    /** 分发模式,如iphash、round-robin、random */
    private DispatchModeEnum dispatchMode;
}
