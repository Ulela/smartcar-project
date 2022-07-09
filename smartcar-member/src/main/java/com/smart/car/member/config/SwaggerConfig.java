package com.smart.car.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 *  不管是knife4j还是swagger-bootstrap-ui
 *  对外提供的地址依然是doc.html
 * @author chenf
 * @version 1.0
 * @date 2022-07-09
 */
@EnableSwagger2WebMvc
@Configuration
public class SwaggerConfig {

    /**
     * 配置Swagger信息
     */
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Member用户模块接口层")
                        .description("# 景停系统API管理系统")
                        .termsOfServiceUrl("http://www.iszoutao.com/")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("2.0.8版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.smart.car.member.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

