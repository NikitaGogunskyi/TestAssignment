package com.nikita.hohunskyi.persistance;

import com.nikita.hohunskyi.domain.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * User repository
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity, String> {

}
