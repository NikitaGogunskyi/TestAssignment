package com.nikita.hohunskyi.service;

import com.nikita.hohunskyi.domain.UserEntity;

public interface UserService {

    UserEntity save(UserEntity newUser);

    String login(String username, String password);
}
