package com.myfolder.myfolder.controllers;

import com.myfolder.myfolder.controllers.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    public void create(@RequestBody() UserDto data) {}
}
