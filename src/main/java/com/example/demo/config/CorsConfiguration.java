package com.example.demo.config;

import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfiguration
{
    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
        final var configuration = new org.springframework.web.cors.CorsConfiguration().applyPermitDefaultValues();

        configuration.setAllowedOrigins(ImmutableList.of("*"));

        configuration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        //        configuration.setAllowedMethods(ImmutableList.of("*"));

        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when
        // the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);

        // setAllowedHeaders is important! Without it, OPTIONS pre-flight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(ImmutableList.of(
            "AuthorizationToken",
            "Cache-Control",
            "Content-Type",
            "Access-Control-Allow-Origin"
        ));
        //        configuration.setAllowedHeaders(ImmutableList.of("*"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
