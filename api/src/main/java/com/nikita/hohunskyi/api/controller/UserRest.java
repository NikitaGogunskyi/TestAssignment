package com.nikita.hohunskyi.api.controller;

import com.nikita.hohunskyi.domain.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User rest controller
 */
@RestController
@Validated
public class UserRest {

    @Autowired
    public UserRest() {

    }

    @GetMapping("/user")
    UserDto all() {
        return new UserDto();
    }
}
