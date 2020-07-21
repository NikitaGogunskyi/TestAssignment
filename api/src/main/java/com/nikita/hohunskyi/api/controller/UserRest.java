package com.nikita.hohunskyi.api.controller;

import com.nikita.hohunskyi.api.converter.service.ExtendedConversionService;
import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.domain.dto.CreateUserDto;
import com.nikita.hohunskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * User rest controller
 */
@RestController
@Validated
public class UserRest {

    private UserService userService;

    private ExtendedConversionService conversionService;

    @Autowired
    public UserRest(UserService userService, ExtendedConversionService conversionService) {
        this.userService = userService;
        this.conversionService = conversionService;
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewUser(@RequestBody @Valid CreateUserDto newUser) {
        UserEntity userEntity = conversionService.convert(newUser, UserEntity.class);
        userService.save(userEntity);
    }
}
