package com.jiesz.mybatis.plus.generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置类
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 配置api文档
     */
    @Bean
    public Docket configApiDocs() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("错误请求").build());
        responseMessageList.add(new ResponseMessageBuilder().code(401).message("未授权").build());
        responseMessageList.add(new ResponseMessageBuilder().code(403).message("禁止").build());
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("未找到").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());

        StringBuilder desc = new StringBuilder();
        desc.append("描述");

        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(new ApiInfoBuilder()
                        .title("API文档")
                        .description(desc.toString())
                        .contact(new Contact("Jiesz", null, "601116847@qq.com"))
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiesz.mybatis.plus.generator"))
                .paths(PathSelectors.any())
                .build();
    }

}
