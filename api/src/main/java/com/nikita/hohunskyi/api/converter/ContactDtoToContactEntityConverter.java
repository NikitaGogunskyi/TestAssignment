package com.nikita.hohunskyi.api.converter;

import com.nikita.hohunskyi.domain.*;
import com.nikita.hohunskyi.domain.dto.ContactDto;
import com.nikita.hohunskyi.persistence.utils.IdGeneratorUtils;
import com.nikita.hohunskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ContactDtoToContactEntityConverter implements Converter<ContactDto, ContactEntity> {

    private UserService userService;

    @Autowired
    public ContactDtoToContactEntityConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ContactEntity convert(ContactDto contactDto) {
        ContactEntity entity = new ContactEntity();
        entity.setId(IdGeneratorUtils.generateUUID());
        entity.setName(contactDto.getName());
        entity.setUser(userService.getCurrentUser().getUserEntity());
        entity.setEmailEntities(convertToContactEmailEntity(contactDto, entity));
        entity.setPhoneNumberEntities(convertToContactPhoneNumberEntity(contactDto, entity));
        return entity;
    }

    private Set<ContactEmailEntity> convertToContactEmailEntity(ContactDto source, ContactEntity contactEntity) {
        return source.getEmails().stream().map(email -> {
            ContactEmailEntity contactEmailEntity = new ContactEmailEntity();
            EmailEntity emailEntity = new EmailEntity();
            emailEntity.setEmail(email);
            emailEntity.setId(IdGeneratorUtils.generateUUID());
            contactEmailEntity.setEmail(emailEntity);
            contactEmailEntity.setId(IdGeneratorUtils.generateUUID());
            contactEmailEntity.setContact(contactEntity);
            return contactEmailEntity;
        }).collect(Collectors.toSet());
    }

    private Set<ContactPhoneNumberEntity> convertToContactPhoneNumberEntity(ContactDto source, ContactEntity contactEntity) {
        return source.getNumbers().stream().map(phoneNumber -> {
            ContactPhoneNumberEntity contactPhoneNumberEntity = new ContactPhoneNumberEntity();
            PhoneNumberEntity numberEntity = new PhoneNumberEntity();
            numberEntity.setNumber(phoneNumber);
            numberEntity.setId(IdGeneratorUtils.generateUUID());
            contactPhoneNumberEntity.setNumber(numberEntity);
            contactPhoneNumberEntity.setId(IdGeneratorUtils.generateUUID());
            contactPhoneNumberEntity.setContact(contactEntity);
            return contactPhoneNumberEntity;
        }).collect(Collectors.toSet());
    }
}
