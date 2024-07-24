package com.myfolder.myfolder.controllers;

import com.myfolder.myfolder.controllers.dto.AuthDto;
import com.myfolder.myfolder.controllers.dto.UserResponse;
import com.myfolder.myfolder.controllers.dto.UserDto;
import com.myfolder.myfolder.domain.entities.UserEntity;
import com.myfolder.myfolder.domain.exceptions.DomainValidationException;
import com.myfolder.myfolder.domain.exceptions.NotFoundException;
import com.myfolder.myfolder.services.auth.AuthService;
import com.myfolder.myfolder.services.user.CreateUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final CreateUserService createUserService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> create(@RequestBody() UserDto data) throws DomainValidationException {
        UserEntity user = createUserService.create(data);
        UserResponse userResponse = new UserResponse(user.id(), user.name(), user.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> auth(@RequestBody() AuthDto data) throws DomainValidationException, NotFoundException {
        String token = authService.auth(data.getEmail(), data.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
