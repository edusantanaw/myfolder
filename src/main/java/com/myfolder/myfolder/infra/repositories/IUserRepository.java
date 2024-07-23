package com.myfolder.myfolder.infra.repositories;

import com.myfolder.myfolder.infra.entities.UserTable;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface  IUserRepository extends JpaRepository <UserTable, Long>{ }