package dev.dong4j.zeka.starter.sample.launcher.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: ParameterizedType 使用测试 参数化类型 </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.07 21:17
 * @since 1.0.0
 */
@Slf4j
class ParameterizedTypeTest {

    /**
     * 1. map: 获取 ParameterizedType:class java.lang.String
     * 2. map: 获取 ParameterizedType:class com.wangji.demo.ParameterizedTypeTest
     * 3. map:getOwnerType is null
     * 4. map:getRawType:interface java.util.Map
     */
    private Map<String, ParameterizedTypeTest> map;
    /**
     * 1. set1: 获取 ParameterizedType:class java.lang.String
     * 2. set1:getOwnerType is null
     * 3. set1:getRawType:interface java.util.Set
     */
    private Set<String> set1;
    /**
     * 1. clz: 获取 ParameterizedType:?
     * 2. clz:getOwnerType is null
     * 3. clz:getRawType:class java.lang.Class
     */
    private Class<?> clz;
    /**
     * 1. holder: 获取 ParameterizedType:class java.lang.String
     * 2. holder:getOwnerType:class com.wangji.demo.ParameterizedTypeTest
     * 3. holder:getRawType:class com.wangji.demo.ParameterizedTypeTest$Holder
     */
    private Holder<String> holder;

    /**
     * 1. list: 获取 ParameterizedType:class java.lang.String
     * 2. list:getOwnerType is null
     * 3. list:getRawType:interface java.util.List
     */
    private List<String> list;
    /**
     * str:is not ParameterizedType
     */
    private String str;
    /**
     * i:is not ParameterizedType
     */
    private Integer i;
    /**
     * set:is not ParameterizedType
     */
    private Set set;
    /**
     * aList:is not ParameterizedType
     */
    private List aList;
    /**
     * 1. entry: 获取 ParameterizedType:class java.lang.String
     * 2. entry: 获取 ParameterizedType:class java.lang.String
     * 3. entry:getOwnerType:interface java.util.Map
     * 4. entry:getRawType:interface java.util.Map$Entry
     */
    private Map.Entry<String, String> entry;

    /**
     * <p>Description: </p>
     *
     * @param <V> parameter
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.07 21:17
     * @since 1.0.0
     */
    private static class Holder<V> {

    }

    /**
     * 测试泛型参数的三个方法
     * 1. Type [] getActualTypeArguments (); 返回 这个 Type 类型的参数的实际类型数组.  如 Map<String,ParameterizedTypeTest> map 这个 ParameterizedType 返回的是
     * String 类, ParameterizedTypeTest 类的全限定类名的 Type Array.
     * 2. Type getRawType () 返回的是当前这个 ParameterizedType 的类型.  如 Map<String,ParameterizedTypeTest> map 这个 ParameterizedType 返回的是 Map
     * 类的全限定类名的 Type Array.
     * 3. Type getOwnerType (); Returns a Type object representing the type that this type is a member of. 返回的是这个 ParameterizedType 所在的类的
     * Type  (注意当前的 ParameterizedType 必须属于所在类的 member)
     * 比如 Map<String,ParameterizedTypeTest> map 这个 ParameterizedType 的 getOwnerType () 为 null, 而 Map.Entry<String, String>entry 的
     * getOwnerType () 为 Map 所属于的 Type
     */
    static void testParameterizedType() {
        Field f;
        try {
            Field[] fields = ParameterizedTypeTest.class.getDeclaredFields();
            for (Field field : fields) {
                f = field;
                if (f.getName().equals("log")) {
                    continue;
                }
                if (f.getGenericType() instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) f.getGenericType();
                    for (Type type : parameterizedType.getActualTypeArguments()) {
                        log.info(f.getName() + ": 获取 ParameterizedType:" + type);
                    }
                    if (parameterizedType.getOwnerType() != null) {
                        log.info(f.getName() + ":getOwnerType:" + parameterizedType.getOwnerType());
                    } else {
                        log.info(f.getName() + ":getOwnerType is null");
                    }
                    if (parameterizedType.getRawType() != null) {
                        log.info(f.getName() + ":getRawType:" + parameterizedType.getRawType());
                    }
                } else {
                    log.info(f.getName() + ":is not ParameterizedType ");
                }
            }
        } catch (Exception e) {
            log.error("error", e);
        }
    }


    /**
     * Test
     *
     * @since 1.0.0
     */
    @Test
    void test() {
        testParameterizedType();
    }

}
