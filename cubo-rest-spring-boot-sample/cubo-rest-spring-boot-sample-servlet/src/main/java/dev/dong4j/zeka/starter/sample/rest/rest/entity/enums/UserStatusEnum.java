package dev.dong4j.zeka.starter.sample.rest.rest.entity.enums;

import dev.dong4j.zeka.kernel.common.enums.SerializeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:09
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum implements SerializeEnum<Integer> {
    /** Not check user status enum */
    NOT_CHECK(1, "未审核"),
    /** Checking user status enum */
    CHECKING(3, "审核中"),
    /** Check failed user status enum */
    CHECK_FAILED(5, "审核未通过"),
    /** Checked user status enum */
    CHECKED(7, "已锁定"),
    /** Normal user status enum */
    NORMAL(9, "正常状态");

    /** 数据库存储的值 */
    private final Integer value;
    /** 枚举描述 */
    private final String desc;
}
