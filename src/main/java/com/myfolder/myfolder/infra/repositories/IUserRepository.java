package com.myfolder.myfolder.infra.repositories;

import com.myfolder.myfolder.infra.entities.UserTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface  IUserRepository extends CrudRepository<UserTable, Long> {
    Optional<UserTable> findByEmail(String email);
}