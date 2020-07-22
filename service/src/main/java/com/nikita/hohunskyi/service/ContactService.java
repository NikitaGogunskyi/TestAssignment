package com.nikita.hohunskyi.service;


import com.nikita.hohunskyi.domain.ContactEntity;

import java.util.Set;

public interface ContactService {

    ContactEntity save(ContactEntity newContactEntity);

    Set<ContactEntity> getUserContacts();
}
