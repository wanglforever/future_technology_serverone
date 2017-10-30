package com.future.technology.serverone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableAutoConfiguration
public class UdbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdbsApplication.class, args);
	}
}
