package com.myfolder.myfolder.services.user;

import com.myfolder.myfolder.controllers.dto.UserDto;
import com.myfolder.myfolder.domain.entities.UserEntity;
import com.myfolder.myfolder.domain.enums.UserRole;
import com.myfolder.myfolder.domain.exceptions.DomainValidationException;
import com.myfolder.myfolder.infra.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service()
@AllArgsConstructor
public class CreateUserService {
    private final UserGateway userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity create(UserDto data) throws DomainValidationException {
        Optional<UserEntity> userByEmail = userRepository.findByEmail(data.getEmail());
        boolean isEmailAlreadyUsed = userByEmail.isEmpty();
        if (!isEmailAlreadyUsed) throw new DomainValidationException("O email já está em uso!");
        String hashedPassword = passwordEncoder.encode(data.getPassword());
        UserEntity user = new UserEntity(null, data.getName(), data.getEmail(), hashedPassword, UserRole.USER);
        return userRepository.create(user);
    }
}
