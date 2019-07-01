/**
 * 
 */
package com.sample.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * The Class SwaggerConfig.
 *
 * @author BRAJENDRA SINGH
 */
@Configuration
public class SwaggerConfig {

	/**
	 * Swagger plugin.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket swaggerPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.sample"))
				.paths(PathSelectors.ant("/*")).build().apiInfo(apiInfo());
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Sample Application").description("Sample Application For Webservices")
				.contact(new Contact("Brajendra", "www.http://brajendra.com", "brajendrasingh@gmail.com"))
				.license("Apna License Version").licenseUrl("https://LICENSE").version("2.0").build();
	}
}
