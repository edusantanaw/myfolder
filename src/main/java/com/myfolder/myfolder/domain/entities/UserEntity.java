package com.myfolder.myfolder.domain.entities;

import com.myfolder.myfolder.domain.enums.UserRole;

public record UserEntity(Long id, String name, String email, String password, UserRole role) {
}
