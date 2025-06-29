package dev.dong4j.zeka.starter.sample.rest.rest.controller;

import dev.dong4j.zeka.kernel.common.api.Result;
import dev.dong4j.zeka.kernel.common.base.BaseForm;
import dev.dong4j.zeka.kernel.common.enums.SerializeEnum;
import dev.dong4j.zeka.starter.rest.ServletController;
import dev.dong4j.zeka.starter.rest.annotation.RequestAbstractForm;
import dev.dong4j.zeka.starter.rest.annotation.RestControllerWrapper;
import dev.dong4j.zeka.starter.rest.support.SubClassType;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: rest 接口接收抽象类参数, 由于 jackson 反序列化为抽象类需要指定子类的标识, 这里通过 @RequestAbstractForm 进行简化处理 </p>
 * 需要注意的是:
 * 1. RequestAbstractForm.value 属性是一个实现了 SubClassType 的子类 class, 且也要实现 SerializeEnum 接口
 * 2. 枚举类型前端可以传入 value/name/枚举下标
 * 3. 此注解只处理抽象类且支持嵌套抽象类
 *
 * @author dong4j
 * @version 1.4.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.05.23 21:49
 * @see RequestAbstractFormMethodArgumentResolver
 * @since 1.4.0
 */
@Slf4j
@RestController
@SuppressWarnings("all")
@RestControllerWrapper("/param")
public class RequestAbstractFormController extends ServletController {

    /**
     * POST http://127.0.0.1:18497/param/10
     * <p>
     * {
     * "username": "dong4j",
     * "password": "dong4j",
     * "type": 1
     * }
     *
     * @param form form
     * @return the result
     * @since 1.4.0
     */
    @PostMapping("/10")
    public Result<AbstractForm> param_10(@RequestAbstractForm(Type.class) AbstractForm form) {
        log.info("{}", form);
        return this.ok(form);
    }

    /**
     * <p>Description: </p>
     *
     * @param <T> parameter
     * @author dong4j
     * @version 1.4.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.05.23 21:50
     * @since 1.4.0
     */
    @Data
    private static abstract class AbstractForm<T extends Serializable> extends BaseForm<T> {
        /** Username */
        protected String username;
        /** Password */
        protected String password;
        /** Type */
        protected Type type;
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.4.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.05.23 21:50
     * @since 1.4.0
     */
    @Data
    private static class A extends AbstractForm<String> {
        /** Aaa */
        private String aaa;
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.4.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.05.23 21:50
     * @since 1.4.0
     */
    @Data
    private static class B extends AbstractForm<String> {
        /** Bbb */
        private String bbb;
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.4.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.05.23 21:50
     * @since 1.4.0
     */
    @Getter
    @AllArgsConstructor
    public static enum Type implements SubClassType, SerializeEnum<Integer> {
        /** Aa type */
        AA(1, "xxxx", A.class),
        /** Bb type */
        BB(2, "yyyy", B.class);

        /** Value */
        private final Integer value;
        /** Desc */
        private final String desc;
        /** Sub class */
        private final Class<?> subClass;
    }
}
