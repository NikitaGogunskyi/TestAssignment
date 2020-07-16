package com.nikita.hohunskyi.persistence;

import com.nikita.hohunskyi.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

}
