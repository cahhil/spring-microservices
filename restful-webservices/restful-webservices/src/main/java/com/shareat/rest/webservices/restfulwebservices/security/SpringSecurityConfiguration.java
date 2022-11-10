package com.shareat.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //make it os any request has to be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        //show pop-up if a request is not authenticated
        http.httpBasic(Customizer.withDefaults());
        //disable csrf means one can send post and put requests
        http.csrf().disable();

        return http.build();
    }
}
