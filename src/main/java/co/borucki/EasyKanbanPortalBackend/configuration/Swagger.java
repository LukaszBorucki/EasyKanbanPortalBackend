package co.borucki.EasyKanbanPortalBackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("EasyKanbanPortalBackend")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Easy Kanban Portal Backend")
                .description("Api ")
                .contact("Łukasz Borucki")
                .license("GPL")
                .licenseUrl("http://www.borucki.co")
                .version("1.0")
                .build();
    }
}
