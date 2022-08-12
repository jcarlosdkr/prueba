package com.demo;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
        }    
    
    private ApiInfo getApiInfo() {
    	return new ApiInfo(
      		"API REST Examen Service", 
      		"En esta API se puede transferir dinero, mostrar el historico de las transacciones pasadas y obtener el saldo actual de una cuenta.", 
      		"1.0", 
      		null,
      		new Contact("Juan Higuera", "https://www.linkedin.com/in/juancarloshs/", "jcarlos@gmail.com"), 
      		null, null, Collections.emptyList());
	}
    
}