package com.myfolder.myfolder.infra.gateway;

import com.myfolder.myfolder.domain.entities.UserEntity;
import com.myfolder.myfolder.infra.entities.UserTable;
import com.myfolder.myfolder.infra.repositories.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor()
public class UserGateway {
    private final IUserRepository repository;

    public UserEntity create(UserEntity data) {
        UserTable user = UserTable.builder()
                .name(data.name())
                .email(data.email())
                .password(data.password())
                .build();
        UserTable created = repository.save(user);
        return created.toEntity();
    }
}
