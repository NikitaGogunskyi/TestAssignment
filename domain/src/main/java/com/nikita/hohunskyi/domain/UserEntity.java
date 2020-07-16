package com.nikita.hohunskyi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for user.
 */
@Table(name = "users")
@Entity
public class UserEntity extends AbstractEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    public UserEntity() {
        //default constructor
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
