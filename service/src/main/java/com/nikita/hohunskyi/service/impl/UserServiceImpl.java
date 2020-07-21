package com.nikita.hohunskyi.service.impl;

import com.nikita.hohunskyi.domain.CustomUserDetails;
import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.persistence.UserRepository;
import com.nikita.hohunskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return new CustomUserDetails(user.get());
        }
        throw new UsernameNotFoundException(email);
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity newUser){
        return userRepository.save(newUser);
    }
}
