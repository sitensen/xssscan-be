package com.codescan.admin.config;

import com.codescan.admin.common.config.BaseSwaggerConfig;
import com.codescan.admin.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.codescan.admin.modules")
                .title("admin_web_back项目骨架")
                .description("admin_web_back项目相关接口文档")
                .contactName("codescan")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
