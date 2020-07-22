package com.nikita.hohunskyi.persistence;

import com.nikita.hohunskyi.domain.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, String> {

}
