package product.store.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

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
            .apis(RequestHandlerSelectors.basePackage("product.store.controller"))
            .paths(PathSelectors.ant("/products"))
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "PRODUCT STORE REST API",
            "Describes the Product Store API",
            "1.0",
            "https://www.apache.org/licenses/contributor-agreements.html",
            new Contact("99x Tech", "https://www.99xtechnology.com", "info@99x.lk"),
            "License of API", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}
