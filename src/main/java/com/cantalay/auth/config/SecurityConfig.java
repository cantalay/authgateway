package com.cantalay.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        http
                .authorizeExchange(authorize -> authorize
                        .pathMatchers("/actuator/**").permitAll()
                        .anyExchange().authenticated())
                .oauth2Login(oauth2 -> {
                })
                .oauth2Client(oauth2 -> {
                })
                .oauth2ResourceServer(resourceServer -> resourceServer
                        .jwt(jwt -> {})
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
