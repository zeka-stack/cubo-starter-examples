package dev.dong4j.zeka.starter.sample.launcher.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>Description: 使用 spring 获取 Field 中变量的泛型信息 </p>
 * https://blog.csdn.net/u012881904/article/details/80813294
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.07 21:18
 * @since 1.0.0
 */
@Slf4j
class SpringResolvableTypeGenericClass {

    /** List string */
    private List<String> listString;
    /** List lists */
    private List<List<String>> listLists;
    /** Maps */
    private Map<String, Long> maps;
    /** Parent */
    private Parent<String> parent;

    /**
     * Gets maps *
     *
     * @return the maps
     * @since 1.0.0
     */
    Map<String, Long> getMaps() {
        return this.maps;
    }

    /**
     * private Parent<String> parent;
     * parent type:com.wangji.demo.Parent<java.lang.String>
     * 泛型参数为: class java.lang.String
     *
     * @since 1.0.0
     */
    static void doTestFindParent() {
        ResolvableType parentResolvableType = ResolvableType.forField(Objects.requireNonNull(ReflectionUtils.findField(SpringResolvableTypeGenericClass.class, "parent")));
        log.info("parent type:" + parentResolvableType.getType());

        // 获取第 0 个位置的参数泛型
        Class<?> resolve = parentResolvableType.getGeneric(0).resolve();
        log.info(" 泛型参数为: " + resolve);

    }

    /**
     * private List<String> listString;
     * listString type:java.util.List<java.lang.String>
     * 泛型参数为: class java.lang.String
     *
     * @since 1.0.0
     */
    static void doTestFindListStr() {
        ResolvableType listStringResolvableType = ResolvableType.forField(Objects.requireNonNull(ReflectionUtils.findField(SpringResolvableTypeGenericClass.class, "listString")));
        log.info("listString type:" + listStringResolvableType.getType());

        // 获取第 0 个位置的参数泛型
        Class<?> resolve = listStringResolvableType.getGeneric(0).resolve();
        log.info(" 泛型参数为: " + resolve);

    }

    /**
     * private List<List<String>> listLists;
     * listLists type:java.util.List<java.util.List<java.lang.String>>
     * 泛型参数为: interface java.util.List
     * 泛型参数为: class java.lang.String
     * 泛型参数为: class java.lang.String
     * begin 遍历
     * 泛型参数为: java.util.List<java.lang.String>
     * end 遍历
     *
     * @since 1.0.0
     */
    static void doTestFindlistLists() {
        ResolvableType listListsResolvableType = ResolvableType.forField(Objects.requireNonNull(ReflectionUtils.findField(SpringResolvableTypeGenericClass.class, "listLists")));
        log.info("listLists type:" + listListsResolvableType.getType());

        // 获取第 0 个位置的参数泛型
        Class<?> resolve = listListsResolvableType.getGeneric(0).resolve();
        log.info(" 泛型参数为: " + resolve);

        // region 这两种实现方式一样的 泛型参数为: class java.lang.String
        resolve = listListsResolvableType.getGeneric(0).getGeneric(0).resolve();
        log.info(" 泛型参数为: " + resolve);

        resolve = listListsResolvableType.getGeneric(0, 0).resolve();
        log.info(" 泛型参数为: " + resolve);
        // endregion

        ResolvableType[] resolvableTypes = listListsResolvableType.getGenerics();
        log.info("begin 遍历 ");
        for (ResolvableType resolvableType : resolvableTypes) {
            resolve = resolvableType.resolve();
            log.info(" 泛型参数为: " + resolve);
        }
        log.info("end 遍历 ");
    }

    /**
     * private Map<String, Long> maps;
     *
     * @since 1.0.0
     */
    static void doTestFindMaps() {
        ResolvableType mapsResolvableType = ResolvableType.forField(Objects.requireNonNull(ReflectionUtils.findField(SpringResolvableTypeGenericClass.class, "maps")));
        log.info("maps type:" + mapsResolvableType.getType());

        log.info("begin 遍历 ");
        ResolvableType[] resolvableTypes = mapsResolvableType.getGenerics();
        Class<?> resolve;
        for (ResolvableType resolvableType : resolvableTypes) {
            resolve = resolvableType.resolve();
            log.info(" 泛型参数为: " + resolve);
        }
        log.info("end 遍历 ");

    }

    /**
     * Do test find return
     *
     * @since 1.0.0
     */
    static void doTestFindReturn() {
        // Spring 的提供工具类, 用于方法的返回值的泛型信息
        ResolvableType resolvableType = ResolvableType.forMethodReturnType(Objects.requireNonNull(ReflectionUtils.findMethod(SpringResolvableTypeGenericClass.class, "getMaps")));
        log.info("maps type:" + resolvableType.getType());
        log.info("begin 遍历 ");
        ResolvableType[] resolvableTypes = resolvableType.getGenerics();
        Class<?> resolve;
        for (ResolvableType resolvableTypeItem : resolvableTypes) {
            resolve = resolvableTypeItem.resolve();
            log.info(" 泛型参数为: " + resolve);
        }
        log.info("end 遍历 ");

    }

    /**
     * 总结一句话就是使用起来非常的简单方便, 更多超级复杂的可以参考 spring 源码中的测试用例: ResolvableTypeTests
     * 其实这些的使用都是在 Java 的基础上进行使用的哦!
     * Type 是 Java 编程语言中所有类型的公共高级接口 (官方解释) , 也就是 Java 中所有类型的 “爹”; 其中, “所有类型” 的描述尤为值得关注. 它并不是我们平常工作中经常使用的 int. String. List. Map 等数据类型,
     * 而是从 Java 语言角度来说, 对基本类型. 引用类型向上的抽象;
     * Type 体系中类型的包括: 原始类型 (Class). 参数化类型 (ParameterizedType). 数组类型 (GenericArrayType). 类型变量 (TypeVariable). 基本类型 (Class);
     * 原始类型, 不仅仅包含我们平常所指的类, 还包括枚举. 数组. 注解等;
     * 参数化类型, 就是我们平常所用到的泛型 List. Map;
     * 数组类型, 并不是我们工作中所使用的数组 String [] . byte [], 而是带有泛型的数组, 即 T [] ;
     * 基本类型, 也就是我们所说的 java 的基本类型, 即 int,float,double 等
     * <p>
     * ResolvableType 为所有的 java 类型提供了统一的数据结构以及 API, 换句话说, 一个 ResolvableType 对象就对应着一种 java 类型. 我们可以通过 ResolvableType 对象获取类型携带的信息 (举例如下) :
     * 1.getSuperType (): 获取直接父类型
     * 2.getInterfaces (): 获取接口类型
     * 3.getGeneric (int...): 获取类型携带的泛型类型
     * 4.resolve (): Type 对象到 Class 对象的转换
     * 另外, ResolvableType 的构造方法全部为私有的, 我们不能直接 new, 只能使用其提供的静态方法进行类型获取:
     * 1.forField (Field): 获取指定字段的类型
     * 2.forMethodParameter (Method, int): 获取指定方法的指定形参的类型
     * 3.forMethodReturnType (Method): 获取指定方法的返回值的类型
     * 4.forClass (Class): 直接封装指定的类型
     * 5.ResolvableType.forInstance 获取指定的实例的泛型信息
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        doTestFindParent();
        doTestFindListStr();
        doTestFindlistLists();
        doTestFindMaps();
        doTestFindReturn();
    }
}
