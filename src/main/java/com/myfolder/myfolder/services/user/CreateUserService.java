package com.myfolder.myfolder.services.user;

import com.myfolder.myfolder.controllers.dto.UserDto;
import com.myfolder.myfolder.infra.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service()
@AllArgsConstructor
public class CreateUserService {
    private final UserGateway userRepository;

    public void create(UserDto data) {

    }
}
