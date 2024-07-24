package com.myfolder.myfolder.infra.entities;

import com.myfolder.myfolder.domain.entities.FolderEntity;
import com.myfolder.myfolder.domain.entities.UserEntity;
import com.myfolder.myfolder.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@Table(name = "db_user")
@NoArgsConstructor
@AllArgsConstructor
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
    List<FolderTable> folders;

    public UserEntity toEntity() {
        return new UserEntity(id, name, email, password, role);
    }

    public User toUserDetails() {return new User(id, name, email, password, role);}
}
