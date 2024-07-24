package com.myfolder.myfolder.services.auth;

import com.myfolder.myfolder.config.security.JwtService;
import com.myfolder.myfolder.domain.exceptions.NotFoundException;
import com.myfolder.myfolder.infra.entities.User;
import com.myfolder.myfolder.infra.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserGateway userGateway;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String auth(String email, String password) throws NotFoundException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Optional<User> userDetails = userGateway.findUserDetailsByEmail(email);
        if (userDetails.isEmpty()) throw new NotFoundException("Usuario não encontrado!");
        User user = userDetails.get();
        return jwtService.generate(user);
    }
}
