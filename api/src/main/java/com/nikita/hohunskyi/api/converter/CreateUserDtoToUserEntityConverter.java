package com.nikita.hohunskyi.api.converter;

import com.nikita.hohunskyi.domain.Role;
import com.nikita.hohunskyi.domain.UserEntity;
import com.nikita.hohunskyi.domain.dto.CreateUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CreateUserDtoToUserEntityConverter implements Converter<CreateUserDto, UserEntity> {
    @Override
    public UserEntity convert(CreateUserDto createUserDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(createUserDto.getEmail());
        userEntity.setPassword(createUserDto.getPassword());
        userEntity.setRole(Role.USER);
        return userEntity;
    }
}
