package com.myfolder.myfolder.config.security;

import com.myfolder.myfolder.infra.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@AllArgsConstructor
public class AuthConfig {
    private final UserGateway userGateway;

    @Bean
    public UserDetailsService userDetailsService() {
        return username ->  userGateway.findUserDetailsByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado!"));
    }
}
