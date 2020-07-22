package com.nikita.hohunskyi.persistence;

import com.nikita.hohunskyi.domain.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, String> {

    Optional<ContactEntity> findByNameAndUserId(@Param("name") String name, @Param("userId") String id);

    Set<ContactEntity> findAllByUserId(@Param("userId")String userId);

}
