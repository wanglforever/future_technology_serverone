package com.future.technology.serverone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: wangl
 * Date: 2017/10/12
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Configuration
public class CORSConfig {
    @Bean
    WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET","POST","PUT","PATCH","DELETE","OPTIONS")
                        .exposedHeaders("Content-Disposition");
            }
        };
    }
}
