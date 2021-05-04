package javawizards.surveywzrd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringBootSwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInformation())
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(xAuthTokenSecurityContext()));
    }

    private ApiInfo getApiInformation() {
        return new ApiInfo("SurveyWzrd",
                "SurveyWzrd Backend Developed by Kathrin und Daniel, Tests by Mauritz",
                "1.0",
                "",
                new Contact("", "", ""),
                "API License",
                "API License URL",
                Collections.emptyList()
        );

    }

    private SecurityContext xAuthTokenSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(
                        new SecurityReference("x-api-key",
                                new AuthorizationScope[0])))
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "x-api-key", "header");
    }


}