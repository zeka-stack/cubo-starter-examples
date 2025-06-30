package dev.dong4j.zeka.starter.sample.mybatis.integration.wrapper;

import dev.dong4j.zeka.kernel.common.util.EnumUtils;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.dto.UserDTO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.po.User;
import dev.dong4j.zeka.starter.sample.mybatis.integration.entity.vo.UserVO;
import dev.dong4j.zeka.starter.sample.mybatis.integration.enums.GenderEnum;
import java.util.Optional;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p>Description:  user 转换器  </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.26 20:41
 * @since 1.0.0
 */
@Mapper(uses = UserMapstructWrapper.UserTransform.class)
public interface UserMapstructWrapper {
    /**
     * The constant INSTANCE.
     */
    UserMapstructWrapper INSTANCE = Mappers.getMapper(UserMapstructWrapper.class);

    /**
     * Dto to user user.
     *
     * @param userDTO the user dto
     * @return the user
     * @since 1.0.0
     */
    User fromDTO(UserDTO userDTO);

    /**
     * User to dto user dto.
     *
     * @param user the user
     * @return the user dto
     * @since 1.0.0
     */
    UserDTO toDTO(User user);

    /**
     * From vo user.
     *
     * @param userVO the user vo
     * @return the user
     * @since 1.0.0
     */
    User fromVO(UserVO userVO);

    /**
     * User to vo user vo.
     *
     * @param user the user
     * @return the user vo
     * @since 1.0.0
     */
    UserVO toVO(User user);

    /**
     * Dto from vo user dto.
     *
     * @param userVO the user vo
     * @return the user dto
     * @since 1.0.0
     */
    UserDTO dtoFromVO(UserVO userVO);

    /**
     * Vo from dto user vo.
     *
     * @param userDTO the user dto
     * @return the user vo
     * @since 1.0.0
     */
    UserVO voFromDTO(UserDTO userDTO);

    /**
     * The type User transform.
     *
     * @author dong4j
     * @version 1.0.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.01.26 20:41
     * @since 1.0.0
     */
    @UtilityClass
    class UserTransform {

        /**
         * Value to enums gender enum.
         *
         * @param value the value
         * @return the gender enum
         * @since 1.0.0
         */
        static GenderEnum valueToEnums(Integer value) {
            Optional<GenderEnum> m = EnumUtils.of(GenderEnum.class, e -> e.getValue().equals(value));
            return m.orElseThrow(() -> new IllegalStateException("未找到对应的 GenderEnum! value = " + value));
        }

        /**
         * Enums to value integer.
         *
         * @param genderEnum the gender enum
         * @return the integer
         * @since 1.0.0
         */
        static Integer enumsToValue(@NotNull GenderEnum genderEnum) {
            return genderEnum.getValue();
        }
    }
}
