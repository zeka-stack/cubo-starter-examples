package dev.dong4j.zeka.starter.sample.rest.rest;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

/**
 * <p>Description: 手动加入接口 </p>
 *
 * @author dong4j
 * @version 1.0.0
 * @email "mailto:dong4j@gmail.com"
 * @date 2020.12.21 01:12
 * @since 1.7.0
 */
@Component
@SuppressWarnings("all")
public class SwaggerAddtion implements ApiListingScannerPlugin {
    /**
     * Apply
     *
     * @param documentationContext documentation context
     * @return the list
     * @since 1.7.0
     */
    @Override
    public List<ApiDescription> apply(DocumentationContext documentationContext) {
        return new ArrayList<>(
            Collections.singletonList(
                new ApiDescription(
                    "/oauth/token",  // url
                    "UserToken", // 描述
                    Collections.singletonList(
                        new OperationBuilder(
                            new CachingOperationNameGenerator())
                            .method(HttpMethod.POST)// http请求类型
                            .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                            .summary("获取token")
                            .notes("获取token")// 方法描述
                            .tags(Sets.newHashSet("Token"))// 归类标签
                            .parameters(
                                Arrays.asList(
                                    new ParameterBuilder()
                                        .description("oauth2鉴权方式，如password")// 参数描述
                                        .type(new TypeResolver().resolve(String.class))// 参数数据类型
                                        .name("grant_type")// 参数名称
                                        .defaultValue("password")// 参数默认值
                                        .parameterType("query")// 参数类型
                                        .parameterAccess("access")
                                        .required(true)// 是否必填
                                        .modelRef(new ModelRef("string")) // 参数数据类型
                                        .build(),
                                    new ParameterBuilder()
                                        .description("用户名")
                                        .type(new TypeResolver().resolve(String.class))
                                        .name("username")
                                        .parameterType("query")
                                        .parameterAccess("access")
                                        .required(true)
                                        .modelRef(new ModelRef("string")) //<5>
                                        .build(),
                                    new ParameterBuilder()
                                        .description("密码")
                                        .type(new TypeResolver().resolve(String.class))
                                        .name("password")
                                        .parameterType("query")
                                        .parameterAccess("access")
                                        .required(true)
                                        .modelRef(new ModelRef("string")) //<5>
                                        .build()
                                ))
                            .build()),
                    false)));
    }

    /**
     * Supports
     *
     * @param documentationType documentation type
     * @return the boolean
     * @since 1.7.0
     */
    @Override
    public boolean supports(DocumentationType documentationType) {
        return DocumentationType.SWAGGER_2.equals(documentationType);
    }
}
