package bergony.ml.rest_api.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.config.EnableWebFlux;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
//
//import java.util.ArrayList;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("bergony.ml.rest_api"))
//                .paths(PathSelectors.any())
//                .build()
//                .pathMapping("/")
//                .apiInfo(metaData());
//    }
//
//    private ApiInfo metaData(){
//
//        Contact contact = new Contact("Bergony", "https://bergony.ml/about/",
//                "bergony@hotmail.com");
//
//        return new ApiInfo(
//                "Na Luz das Abordagens",
//                "Projeto na luz das abordagens rest api",
//                "0.0.1",
//                "Terms of Service: blah",
//                contact,
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList<>());
//    }
//}
