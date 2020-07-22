package com.nikita.hohunskyi.service.impl;

import com.nikita.hohunskyi.domain.ContactEntity;
import com.nikita.hohunskyi.persistence.ContactRepository;
import com.nikita.hohunskyi.service.ContactService;
import com.nikita.hohunskyi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private final UserService userService;

    public ContactServiceImpl(ContactRepository contactRepository,
                              UserService userService) {
        this.contactRepository = contactRepository;
        this.userService = userService;
    }

    @Override
    public ContactEntity save(ContactEntity newContactEntity) {
        if (contactRepository.findByNameAndUserId(newContactEntity.getName(),
                newContactEntity.getUser().getId()).isPresent()) {
            throw new IllegalStateException("Contact Already Exist");
        }
        return contactRepository.save(newContactEntity);
    }

    @Override
    public Set<ContactEntity> getUserContacts() {
        String userId = userService.getCurrentUser().getUserEntity().getId();
        return contactRepository.findAllByUserId(userId);
    }
}
