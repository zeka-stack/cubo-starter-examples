package dev.dong4j.zeka.starter.sample.rest.rest.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "用户基本信息")
public class User {
    /** Id */
    @ApiModelProperty(value = "用户 ID", dataType = "Long")
    private Long id;
    /** Name */
    @ApiModelProperty("姓名")
    private String name;
    /** Age */
    @ApiModelProperty("年龄")
    private Integer age;
    /** Address */
    @ApiModelProperty("地址")
    private String address;
    /** Email */
    @ApiModelProperty("邮箱")
    private String email;
    /** Date */
    private Date date;
}
