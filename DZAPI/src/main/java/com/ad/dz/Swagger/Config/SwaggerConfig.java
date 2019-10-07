package com.ad.dz.Swagger.Config;

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
	public Docket JPlan()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metaData())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo metaData() 
	{
	    ApiInfo apiInfo =  new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Journey Planning",
                "1.0",
                "Terms of service",
                new Contact("Arun Kumar", "https://www.linkedin.com/in/dkumararun/", "arun.akdhiman@gmail.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", null);
	    
	    return apiInfo;
	}
}