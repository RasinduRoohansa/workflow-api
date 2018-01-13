package com.spsolutions.grand.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Stelan Briyan
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spsolutions.grand"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Dashboard Service - Swagger Rest API Documentation",
                "Spring Boot - The Grand Hotel",
                "1.0",
                "Terms of Service",
                new Contact("SP-SOLUTIONS", "http://australianstrategicpartnerships.com/",
                        "info@spsolutions.biz"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );
        return apiInfo;
    }
}