package dev.dong4j.zeka.starter.sample.launcher.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * <p>Description:
 * GenericArrayType—— 泛型数组
 * 泛型数组, 描述的是形如: A<T>[] 或 T [] 类型
 * </p>
 *
 * @param <T> parameter
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.07 21:15
 * @since 1.0.0
 */
@Slf4j
public class GenericArrayTypeTest<T> {

    /**
     * 含有泛型数组的才是 GenericArrayType
     *
     * @param pTypeArray GenericArrayType type :java.util.List<java.lang.String>[];genericComponentType:java.util.List<java.lang.String>
     * @param vTypeArray GenericArrayType type :T[];genericComponentType:T
     * @param list       ParameterizedType type :java.util.List<java.lang.String>;
     * @param strings    type :class [Ljava.lang.String;
     * @param test       type :class [Lcom.wangji.demo.GenericArrayTypeTest;
     * @since 1.0.0
     */
    public void testGenericArrayType(List<String>[] pTypeArray, T[] vTypeArray, List<String> list, String[] strings, GenericArrayTypeTest[] test) {

    }

    /**
     * Type 是 Java 编程语言中所有类型的公共高级接口 (官方解释) , 也就是 Java 中所有类型的 “爹”; 其中, “所有类型” 的描述尤为值得关注. 它并不是我们平常工作中经常使用的 int. String. List. Map 等数据类型,
     * 而是从 Java 语言角度来说, 对基本类型. 引用类型向上的抽象;
     * Type 体系中类型的包括: 原始类型 (Class). 参数化类型 (ParameterizedType). 数组类型 (GenericArrayType). 类型变量 (TypeVariable). 基本类型 (Class);
     * 原始类型, 不仅仅包含我们平常所指的类, 还包括枚举. 数组. 注解等;
     * 参数化类型, 就是我们平常所用到的泛型 List. Map;
     * 数组类型, 并不是我们工作中所使用的数组 String [] . byte [], 而是带有泛型的数组, 即 T [] ;
     * 基本类型, 也就是我们所说的 java 的基本类型, 即 int,float,double 等
     * <p>
     * 1. getGenericComponentType
     * 返回泛型数组中元素的 Type 类型, 即 List<String>[] 中的 List<String> (ParameterizedTypeImpl) . T [] 中的 T (TypeVariableImpl) ;
     * 值得注意的是, 无论是几维数组, getGenericComponentType () 方法都只会脱去最右边的 [], 返回剩下的值;
     *
     * @since 1.0.0
     */
    static void testGenericArrayType() {
        Method[] declaredMethods = GenericArrayTypeTest.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.getName().startsWith("main")) {
                continue;
            }
            log.info("declare Method:" + method);

            // 获取当前参数所有的类型信息
            Type[] types = method.getGenericParameterTypes();
            for (Type type : types) {
                if (type instanceof ParameterizedType) {
                    log.info("ParameterizedType type :" + type);
                } else if (type instanceof GenericArrayType) {
                    log.info("GenericArrayType type :" + type);
                    Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();

                    /*
                     * 获取泛型数组中元素的类型, 要注意的是: 无论从左向右有几个 [] 并列, 这个方法仅仅脱去最右边的 [] 之后剩下的内容就作为这个方法的返回值.
                     * [Java 源码解析 (附录)(4) —— GenericArrayType](https://blog.csdn.net/a327369238/article/details/52703519)
                     */
                    log.info("genericComponentType:" + genericComponentType);
                } else if (type instanceof WildcardType) {
                    log.info("WildcardType type :" + type);
                } else if (type instanceof TypeVariable) {
                    log.info("TypeVariable type :" + type);
                } else {
                    log.info("type :" + type);
                }
            }
        }
    }

    /**
     * Test
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        testGenericArrayType();
    }
}
