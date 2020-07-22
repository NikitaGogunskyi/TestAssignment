package com.nikita.hohunskyi.api.controller;

import com.nikita.hohunskyi.api.converter.service.ExtendedConversionService;
import com.nikita.hohunskyi.domain.ContactEntity;
import com.nikita.hohunskyi.domain.dto.ContactDto;
import com.nikita.hohunskyi.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class ContactRest {

    private ExtendedConversionService conversionService;

    private ContactService contactService;

    public ContactRest(ExtendedConversionService conversionService, ContactService contactService) {
        this.conversionService = conversionService;
        this.contactService = contactService;
    }

    @PutMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createContact(@Valid @RequestBody ContactDto contactDto) {
        ContactEntity newContactEntity = conversionService.convert(contactDto, ContactEntity.class);
        return ResponseEntity.ok(contactService.save(newContactEntity));
    }

}
