package dev.dong4j.zeka.starter.sample.launcher;

import dev.dong4j.zeka.kernel.common.yml.YmlPropertyLoaderFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.yaml.snakeyaml.scanner.ScannerException;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p>Description: </p>
 *
 * @author dong4j
 * @version 1.2.3
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.01.27 18:19
 * @since 1.0.0
 */
@Slf4j
class YmlPropertyLoaderFactoryTest extends SampleLauncherApplicationTest {

    /** Environment */
    @javax.annotation.Resource
    private Environment environment;

    /**
     * 使用 @ 占位符且没有被 maven 替换, yml 解析将抛出异常
     *
     * @since 1.0.0
     */
    @Test
    void test_1() {
        assertThrows(ScannerException.class, () -> {
            YmlPropertyLoaderFactory ymlPropertyLoaderFactory = new YmlPropertyLoaderFactory();

            // 直接从 classpath 加载资源
            Resource resource = new ClassPathResource("application-at-placeholder.yml");

            ymlPropertyLoaderFactory.createPropertySource(
                "application.yml",
                new EncodedResource(resource, StandardCharsets.UTF_8)
            );
        });
    }

    /**
     * 解析 ${} 占位符, maven 环境变量不能获取, 能获取配置文件中的变量.
     * 解析时需要使用 {@link PropertySourcesPropertyResolver}
     *
     * @since 1.0.0
     */
    @SneakyThrows
    @Test
    void test_2() {
        YmlPropertyLoaderFactory ymlPropertyLoaderFactory = new YmlPropertyLoaderFactory();

        // 从 classpath 加载资源文件
        Resource resource = new ClassPathResource("application-placeholder.yml");

        PropertySource<?> propertySource = ymlPropertyLoaderFactory.createPropertySource(
            "application.yml", new EncodedResource(resource, StandardCharsets.UTF_8)
        );

        PropertyResolver resolver = this.getPropertyResolver(propertySource);

        // 正常解析占位符
        Assertions.assertEquals("bb", resolver.getProperty("zeka-stack.app.custom.cc"));

        // 不能获取 maven 中的环境变量
        Assertions.assertNull(resolver.getProperty("project.artifactId"));
    }

    /**
     * 从 classpath 加载配置, 编译时 maven 会使用 maven 环境中的变量替换占位符, 比如 @project.artifactId@ / ${project.artifactId},
     * 这类占位符替换发生在编译阶段, 可直接使用 environment 获取占位符配置, 可自动替换.
     *
     * @since 1.0.0
     */
    @Test
    void test_ioc() {
        // 使用 environment 来读取占位符配置, 因为是 PropertyResolver 的子类, 可以直接处理占位符
        Assertions.assertEquals("bb", this.environment.getProperty("zeka-stack.app.custom.cc"));
    }

    /**
     * 使用 PropertySourcesPropertyResolver 来解析占位符
     *
     * @param propertySource property source
     * @return the property resolver
     * @see PropertySourcesPlaceholderConfigurer#postProcessBeanFactory PropertySourcesPlaceholderConfigurer
     * #postProcessBeanFactoryPropertySourcesPlaceholderConfigurer#postProcessBeanFactory
     * @since 1.0.0
     */
    @NotNull
    @Contract("_ -> new")
    private PropertyResolver getPropertyResolver(PropertySource propertySource) {
        // 将 PropertySource 添加到 PropertySources, 不添加到 environment
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addLast(propertySource);
        return new PropertySourcesPropertyResolver(propertySources);
    }
}
