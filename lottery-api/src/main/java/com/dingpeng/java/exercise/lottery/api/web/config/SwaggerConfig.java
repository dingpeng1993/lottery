package com.dingpeng.java.exercise.lottery.api.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dp
 * Date: 2019/3/19 13:57
 * Description: @EnableSwagger2注解来启用Swagger2
 * http://localhost:8084/swagger-ui.html
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).enable(enableSwagger)
                .select()
                // 对所有api进行监控
                .apis(RequestHandlerSelectors.basePackage("com.dingpeng.java.exercise.lottery.api.web.controller"))
                // 对所有路径进行监控
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("抽奖系统使用API")
                .description("抽奖系统接口")
                // 条款地址
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("丁鹏", "https://github.com/dingpeng1993/lottery", "15757173945@163.com"))
                .version("v1")
                .build();
    }
}
