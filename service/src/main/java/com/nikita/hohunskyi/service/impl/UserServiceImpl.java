package com.nikita.hohunskyi.service.impl;

import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.domain.constant.ErrorMessages;
import com.nikita.hohunskyi.persistence.UserRepository;
import com.nikita.hohunskyi.persistence.utils.JwtUtils;
import com.nikita.hohunskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    private JwtUtils jwtUtils;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity newUser) {
        checkUserAlreadyExists(newUser.getEmail());
        newUser.setDateAdded(ZonedDateTime.now());
        return userRepository.save(newUser);
    }

    @Override
    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateJwtToken(authentication);
    }

    private void checkUserAlreadyExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException(ErrorMessages.USER_ALREADY_EXISTS);
        }
    }
}
