package dev.dong4j.zeka.starter.sample.launcher;

import dev.dong4j.zeka.kernel.common.util.JsonUtils;
import dev.dong4j.zeka.kernel.test.ZekaTest;
import dev.dong4j.zeka.starter.sample.launcher.config.CustomConfig;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <p>Description:  </p>
 *
 * @author dong4j
 * @version 1.3.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.03.06 13:03
 * @since 1.0.0
 */
@Slf4j
@ZekaTest
class SampleLauncherApplicationTest {
    /** Custom config */
    @Resource
    private CustomConfig customConfig;

    /**
     * 测试自动绑定
     *
     * @since 1.0.0
     */
    @Test
    void test_config() {
        log.info("{}", JsonUtils.toJson(this.customConfig.getConfig1()));
        log.info("{}", JsonUtils.toJson(this.customConfig.getConfig2()));
    }

    /** Environment */
    @Resource
    private Environment environment;

    /**
     * 使用 binder 来解析配置
     *
     * @since 1.0.0
     */
    @Test
    void test_binder() {
        Binder binder = Binder.get(this.environment);
        this.environment.getProperty("zeka-stack.app.custom.cc");
        BindResult<CustomConfig.Config1> config1 = binder.bind("zeka-stack.app.custom.config1", Bindable.of(CustomConfig.Config1.class));
        log.debug("{}", config1.get());
        Assertions.assertEquals(this.customConfig.getConfig1(), config1.get());

        BindResult<CustomConfig.Config2> config2 = binder.bind("zeka-stack.app.custom.config2", Bindable.of(CustomConfig.Config2.class));
        log.debug("{}", config2.get());
        Assertions.assertEquals(this.customConfig.getConfig2(), config2.get());

        String value = binder.bindOrCreate("zeka-stack.app.custom.config1.value", String.class);
        Assertions.assertEquals("345", value);

        String[] strings = binder.bindOrCreate("zeka-stack.app.custom.config1.value-array", String[].class);
        Assertions.assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}, strings);

        List<String> list = binder.bindOrCreate("zeka-stack.app.custom.config1.value-list", Bindable.listOf(String.class));
        Assertions.assertLinesMatch(Arrays.asList("13579", "246810"), list);

        Person person = binder.bindOrCreate("zeka-stack.app.custom.config1.value-map", Bindable.of(Person.class));
        Assertions.assertEquals(Person.builder().name("lili").age(20).build(), person);


        List<Person> personList = binder.bindOrCreate("zeka-stack.app.custom.config1.value-map-list", Bindable.listOf(Person.class));
        Assertions.assertIterableEquals(new ArrayList<Person>() {
            private static final long serialVersionUID = -1081898120915220324L;

            {
                this.add(Person.builder().name("bob").age(21).build());
                this.add(Person.builder().name("caven").age(31).build());
            }
        }, personList);
    }

    /**
     * <p>Description: </p>
     *
     * @author dong4j
     * @version 1.3.0
     * @email "mailto:dong4j@gmail.com"
     * @date 2020.03.07 21:06
     * @since 1.0.0
     */
    @Data
    @Builder
    private static class Person {
        /** Name */
        private String name;
        /** Age */
        private Integer age;

        /**
         * Equals boolean
         *
         * @param o o
         * @return the boolean
         * @since 1.0.0
         */
        @Contract(value = "null -> false", pure = true)
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return this.name.equals(person.name)
                && this.age.equals(person.age);
        }

        /**
         * Hash code int
         *
         * @return the int
         * @since 1.0.0
         */
        @Override
        public int hashCode() {
            return Objects.hash(this.name, this.age);
        }
    }

}
