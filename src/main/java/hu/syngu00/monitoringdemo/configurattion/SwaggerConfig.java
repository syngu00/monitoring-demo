/*
 * Author: V??ncsodi M??rk (Syngu00)
 * Product owner is: V??ncsodi M??rk (Syngu00)
 * Contact: vancsodi.mark@rfit.hu
 * Contributors:
 * This file is part of WebWasteApiProject project.
 * Copyright RF-IT Hungary Kft.(C) 2019 http://www.rfit.hu
 */
package hu.syngu00.monitoringdemo.configurattion;

import hu.syngu00.monitoringdemo.configurattion.proeprties.SwaggerProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SwaggerConfig {

    private final SwaggerProperties properties;

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                title("Demo").
                version("0.0.1-SNAPSHOT").build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .host(properties.getHost())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/resource/**"))
                .build();
    }


}

