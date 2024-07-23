package com.myfolder.myfolder.infra.entities;

import com.myfolder.myfolder.domain.entities.FolderEntity;
import com.myfolder.myfolder.domain.entities.UserEntity;
import com.myfolder.myfolder.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity(name = "db_user")
@Data
@Builder
@Table(name = "db_user")
public class UserTable {
    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    @Column(unique = true, nullable = false)
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    UserRole role;
    @OneToMany(fetch = FetchType.LAZY)
    List<FolderEntity> folders;

    public UserEntity toEntity() {
        return new UserEntity(id, name, email, password, role);
    }
}
