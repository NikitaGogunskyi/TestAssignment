package com.nikita.hohunskyi.service.impl;

import com.nikita.hohunskyi.domain.ContactEntity;
import com.nikita.hohunskyi.persistence.ContactRepository;
import com.nikita.hohunskyi.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactEntity save(ContactEntity newContactEntity) {

        return contactRepository.save(newContactEntity);
    }
}
