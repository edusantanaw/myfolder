package com.myfolder.myfolder.infra.gateway;

import com.myfolder.myfolder.domain.entities.UserEntity;
import com.myfolder.myfolder.infra.entities.User;
import com.myfolder.myfolder.infra.entities.UserTable;
import com.myfolder.myfolder.infra.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor()
public class UserGateway {
    private final IUserRepository repository;

    public UserEntity create(UserEntity data) {
        UserTable user = UserTable.builder()
                .name(data.name())
                .email(data.email())
                .password(data.password())
                .role(data.role())
                .build();
        UserTable created = repository.save(user);
        return created.toEntity();
    }

    public Optional<UserEntity> findByEmail(String email) {
        Optional<UserTable> user = repository.findByEmail(email);
        return user.map(UserTable::toEntity);
    }

    public Optional<User> findUserDetailsByEmail(String email) {
        Optional<UserTable> user = repository.findByEmail(email);
        return user.map(UserTable::toUserDetails).or(() -> Optional.of(null));
    }
}
