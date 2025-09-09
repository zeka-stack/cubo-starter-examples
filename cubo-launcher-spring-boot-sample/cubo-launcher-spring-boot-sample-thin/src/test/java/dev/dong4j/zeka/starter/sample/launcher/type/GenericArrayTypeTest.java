package dev.dong4j.zeka.starter.sample.launcher.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Java反射泛型数组类型测试类，用于测试和学习GenericArrayType的特性和用法
 * <p>
 * 该测试类主要用于演示和测试Java反射API中的GenericArrayType接口
 * GenericArrayType表示泛型数组类型，如A&lt;T&gt;[]或T[]等形式
 * 通过实际代码演示和测试帮助开发者理解Java反射中的泛型系统
 * <p>
 * 主要特性：
 * - 泛型数组演示：展示各种泛型数组类型的定义和使用
 * - 反射分析：通过反射API分析方法参数中的泛型信息
 * - 类型区分：区分处理不同的Type子类型
 * - 教学演示：提供丰富的注释和示例代码
 * - 实用工具：可作为学习和研究Java泛型的工具
 * <p>
 * Java Type系统概述：
 * <p>
 * Type是Java编程语言中所有类型的公共高级接口，也就是Java中所有类型的“爸爸”
 * 它不是我们平常工作中经常使用的int、String、List、Map等数据类型
 * 而是从 Java 语言角度来说，对基本类型、引用类型向上的抽象
 * <p>
 * Type体系中包含的类型：
 * - <b>原始类型(Class)</b>：包含类、枚举、数组、注解等
 * - <b>参数化类型(ParameterizedType)</b>：泛型List&lt;String&gt;、Map&lt;K,V&gt;等
 * - <b>数组类型(GenericArrayType)</b>：带有泛型的数组，如T[]、List&lt;String&gt;[]
 * - <b>类型变量(TypeVariable)</b>：泛型中的类型参数T、K、V等
 * - <b>通配符类型(WildcardType)</b>：通配符? extends Number、? super Integer等
 * <p>
 * GenericArrayType核心概念：
 * <p>
 * <b>定义</b>：GenericArrayType描述的是形如A&lt;T&gt;[]或T[]类型
 * - 注意：不是普通数组String[]、int[]
 * - 必须是包含泛型信息的数组类型
 * <p>
 * <b>核心方法</b>：getGenericComponentType()
 * - 返回泛型数组中元素的Type类型
 * - List&lt;String&gt;[]中返回List&lt;String&gt;（ParameterizedType）
 * - T[]中返回T（TypeVariable）
 * - 无论几维数组，都只会脱去最右边的[]
 * <p>
 * 测试方法说明：
 * <p>
 * <b>testGenericArrayType()</b> - 泛型数组参数定义：
 * - pTypeArray: List&lt;String&gt;[] - GenericArrayType，参数化类型数组
 * - vTypeArray: T[] - GenericArrayType，类型变量数组
 * - list: List&lt;String&gt; - ParameterizedType，参数化类型
 * - strings: String[] - Class，普通数组（非泛型）
 * - test: GenericArrayTypeTest[] - Class，普通对象数组
 * <p>
 * <b>testGenericArrayType()</b> - 静态分析方法：
 * - 通过反射获取类中的所有方法
 * - 分析每个方法的参数类型信息
 * - 区分和识别不同的Type子类型
 * - 输出详细的类型分析结果
 * <p>
 * 实际应用场景：
 * - 框架开发中的泛型解析和处理
 * - ORM框架中的类型映射和转换
 * - JSON序列化反序列化中的类型处理
 * - 代码生成工具中的类型分析
 * - 注解处理器中的参数类型检查
 * <p>
 * 注意事项和最佳实践：
 * - GenericArrayType只适用于包含泛型信息的数组
 * - 普通数组类型会被识别为Class而非GenericArrayType
 * - getGenericComponentType()方法只脱去最右侧的一层[]
 * - 在处理复杂泛型时需要递归分析各级类型
 * - 注意线程安全性，反射操作可能涉及并发问题
 *
 * @param <T> 泛型参数，用于演示类型变量在数组中的应用
 * @author dong4j
 * @version 1.0.0
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
