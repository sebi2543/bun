package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/course/**").authenticated()
                .anyRequest().permitAll()
//                .anyRequest().authenticated()
//                .antMatchers("/**/all").authenticated()

                .and().formLogin()
                .defaultSuccessUrl("http://localhost:3000/")
                .failureUrl("http://localhost:3000/login?error=true ")
                .usernameParameter("userName")
                .passwordParameter("password")
//                .and().logout().logoutSuccessUrl("http://localhost:3000/log-in")
//                .loginPage("http://localhost:3000/log-in")
                .and().csrf().disable().cors(Customizer.withDefaults());
        return http.build();
    }


}
