package com.nikita.hohunskyi.service;

import com.nikita.hohunskyi.domain.CustomUserDetails;
import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.domain.UserPrincipal;

public interface UserService {

    UserEntity save(UserEntity newUser);

    String login(String username, String password);

    CustomUserDetails getCurrentUser();
}
