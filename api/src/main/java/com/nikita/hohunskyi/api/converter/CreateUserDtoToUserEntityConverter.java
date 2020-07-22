package com.nikita.hohunskyi.api.converter;

import com.nikita.hohunskyi.domain.Role;
import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.domain.dto.UserCredentialsDto;
import com.nikita.hohunskyi.persistence.utils.IdGeneratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.time.ZonedDateTime;

@Component
public class CreateUserDtoToUserEntityConverter implements Converter<UserCredentialsDto, UserEntity> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity convert(UserCredentialsDto userCredentialsDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(IdGeneratorUtils.generateUserId());
        userEntity.setEmail(userCredentialsDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userCredentialsDto.getPassword()));
        userEntity.setRole(Role.USER);
        userEntity.setDateAdded(ZonedDateTime.now());
        return userEntity;
    }
}
