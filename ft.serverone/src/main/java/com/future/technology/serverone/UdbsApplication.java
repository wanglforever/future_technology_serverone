package com.future.technology.serverone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableAutoConfiguration
@EnableSwagger2
public class UdbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdbsApplication.class, args);
	}
}
