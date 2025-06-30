package dev.dong4j.zeka.starter.sample.mybatis.integration.wrapper;

import dev.dong4j.zeka.kernel.common.mapstruct.ServiceConverter;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>Description: 用户信息表 服务层转换器, 提供 po 和 dto 互转 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.09.30 14:18
 * @since 1.0.0
 */
@Mapper
public interface UserServiceConverter extends ServiceConverter<UserDTO, User> {

    /** INSTANCE */
    UserServiceConverter INSTANCE = Mappers.getMapper(UserServiceConverter.class);
}
