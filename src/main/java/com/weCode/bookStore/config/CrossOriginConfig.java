package com.weCode.bookStore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CrossOriginConfig implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer{
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
	}
}
