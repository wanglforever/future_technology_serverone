package com.future.technology.serverone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.MultipartConfigElement;

/**
 * Created by three on 2017/12/6.
 */
@Component
public class SourceConfig {
    @Value("${operation.sourceLocation}")
    private String sourceLocation;
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(sourceLocation);
        return factory.createMultipartConfig();
    }
}
