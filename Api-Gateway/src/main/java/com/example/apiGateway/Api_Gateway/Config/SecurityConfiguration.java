package com.example.apiGateway.Api_Gateway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity security){
        security.authorizeExchange()
        .anyExchange()
        .authenticated()
        .and()
        .oauth2Client()
        .and()
        .oauth2ResourceServer()
        .jwt();

        return security.build();

    }
    
}

