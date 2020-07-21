package com.nikita.hohunskyi.api.converter;

import com.nikita.hohunskyi.domain.Role;
import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.domain.dto.UserCredentialsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToUserEntityConverter implements Converter<UserCredentialsDto, UserEntity> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity convert(UserCredentialsDto userCredentialsDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userCredentialsDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userCredentialsDto.getPassword()));
        userEntity.setRole(Role.USER);
        return userEntity;
    }
}
