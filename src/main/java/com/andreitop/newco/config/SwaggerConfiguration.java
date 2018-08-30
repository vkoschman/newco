package com.andreitop.newco.config;

import com.andreitop.newco.common.APIConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.andreitop.newco.controller"))
            .paths(PathSelectors.ant(APIConstant.API_V_1 +"/trips/**"))
            .build()
            .apiInfo(
                new ApiInfoBuilder()
                    .title("My Beautiful RestApi")
                    .contact(new Contact("andrei dremov", "github.com/andreitop", "myemail.com"))
                    .version("1.0-SNAPSHOT")
                    .build()
            );
    }

}
