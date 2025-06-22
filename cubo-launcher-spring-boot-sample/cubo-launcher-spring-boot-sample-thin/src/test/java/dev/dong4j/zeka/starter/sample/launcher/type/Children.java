package dev.dong4j.zeka.starter.sample.launcher.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>Description: 测试泛型 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.07 21:14
 * @since 1.0.0
 */
@Slf4j
class Children extends Parent<String> implements IParent<Long> {

    /**
     * Test
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        // 这里是获取父类中泛型, 如果有多个也是一样的方式哈哈! 获取到的泛型参数还可能是 通配符表达式, 这里也是可以处理的, 多个判断而已
        Type genericSuperclassType = Children.class.getGenericSuperclass();
        if (genericSuperclassType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclassType).getActualTypeArguments();
            for (Type argumentType : actualTypeArguments) {
                log.info(" 父类 ParameterizedType.getActualTypeArguments:" + argumentType);
            }
        }

        // 这里获取父接口中的泛型参数
        Type[] genericInterfacesTypes = Children.class.getGenericInterfaces();
        for (Type interfaceType : genericInterfacesTypes) {
            if (interfaceType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) interfaceType).getActualTypeArguments();
                for (Type argumentType : actualTypeArguments) {
                    log.info(" 父接口 ParameterizedType.getActualTypeArguments:" + argumentType);
                }
            }
        }

        /*
         言归正传, 下面讲解 ResolvableType. ResolvableType 为所有的 java 类型提供了统一的数据结构以及 API, 换句话说, 一个 ResolvableType 对象就对应着一种 java 类型. 我们可以通过
         ResolvableType 对象获取类型携带的信息 (举例如下) :
         1.getSuperType (): 获取直接父类型
         2.getInterfaces (): 获取接口类型
         3.getGeneric (int...): 获取类型携带的泛型类型
         4.resolve (): Type 对象到 Class 对象的转换
         另外, ResolvableType 的构造方法全部为私有的, 我们不能直接 new, 只能使用其提供的静态方法进行类型获取:
         1.forField (Field): 获取指定字段的类型
         2.forMethodParameter (Method, int): 获取指定方法的指定形参的类型
         3.forMethodReturnType (Method): 获取指定方法的返回值的类型
         4.forClass (Class): 直接封装指定的类型
         */
        ResolvableType superResolvableType = ResolvableType.forClass(Children.class).getSuperType();
        log.info("supper:" + superResolvableType.resolveGenerics()[0]);

        ResolvableType superInterfaceResolvableType = ResolvableType.forClass(Children.class).getInterfaces()[0];
        log.info("supper:" + superInterfaceResolvableType.resolveGenerics()[0]);
    }
}
