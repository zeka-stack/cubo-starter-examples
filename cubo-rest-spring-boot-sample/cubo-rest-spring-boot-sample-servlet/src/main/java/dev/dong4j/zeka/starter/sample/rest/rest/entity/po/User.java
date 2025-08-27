package dev.dong4j.zeka.starter.sample.rest.rest.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:22
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "用户基本信息")
public class User {
    /** Id */
    @Schema(description = "用户 ID")
    private Long id;
    /** Name */
    @Schema(defaultValue = "姓名")
    private String name;
    /** Age */
    @Schema(defaultValue = "年龄")
    private Integer age;
    /** Address */
    @Schema(defaultValue = "地址")
    private String address;
    /** Email */
    @Schema(defaultValue = "邮箱")
    private String email;
    /** Date */
    @Schema(defaultValue = "创建时间")
    private Date date;
}
