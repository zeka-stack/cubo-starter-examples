package dev.dong4j.zeka.starter.sample.rest.rest.entity.po;

import dev.dong4j.zeka.starter.sample.rest.rest.entity.enums.UserStatusEnum;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.10 14:45
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnumEntity {

    /** Name */
    private String name;
    /** Status */
    private UserStatusEnum status;
    /** Status list */
    private List<UserStatusEnum> statusList;
    /** Status map */
    private Map<String, UserStatusEnum> statusMap;
}
