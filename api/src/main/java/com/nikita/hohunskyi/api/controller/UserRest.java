package com.nikita.hohunskyi.api.controller;

import com.nikita.hohunskyi.api.converter.service.ExtendedConversionService;
import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.domain.dto.UserCredentialsDto;
import com.nikita.hohunskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public UserRest(UserService userService,
                    ExtendedConversionService conversionService) {
        this.userService = userService;
        this.conversionService = conversionService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addNewUser(@RequestBody @Valid UserCredentialsDto newUser) {
        UserEntity userEntity = conversionService.convert(newUser, UserEntity.class);
        userService.save(userEntity);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid UserCredentialsDto credentials) {
        return ResponseEntity.ok(userService.login(credentials.getUsername(), credentials.getPassword()));
    }
}
