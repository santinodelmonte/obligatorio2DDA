package com.obligatorio2dda.obligatorio2dda;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/api/**")
            .allowedOrigins("http://localhost", "http://localhost:3000") 
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true);
}
}