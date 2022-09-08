package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.security.ApplicationUserRole.ADMIN;
import static com.example.demo.security.ApplicationUserRole.USER;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/profile/all")
            .authenticated()
            .antMatchers("/instructor/all").hasRole(ADMIN.name())
            .and()
            .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
       UserDetails annaSmithUser= User.builder()
                .username("anasmith")
                .password(passwordEncoder.encode( "password"))
                .roles(USER.name())
               .build();

       UserDetails lindaUser = User.builder()
               .username("linda")
               .password(passwordEncoder.encode( "password"))
               .roles(ADMIN.name() )
               .build();

       return new InMemoryUserDetailsManager(annaSmithUser,lindaUser);
    }
}
