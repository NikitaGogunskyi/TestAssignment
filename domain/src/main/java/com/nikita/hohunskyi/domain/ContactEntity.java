package com.nikita.hohunskyi.domain;

import javax.persistence.*;
import java.util.Set;

@Table(name = "contacts")
@Entity
public class ContactEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactEmailEntity> emailEntities;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private Set<ContactPhoneNumberEntity> phoneNumberEntities;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ContactEmailEntity> getEmailEntities() {
        return emailEntities;
    }

    public void setEmailEntities(Set<ContactEmailEntity> emailEntities) {
        this.emailEntities = emailEntities;
    }

    public Set<ContactPhoneNumberEntity> getPhoneNumberEntities() {
        return phoneNumberEntities;
    }

    public void setPhoneNumberEntities(Set<ContactPhoneNumberEntity> phoneNumberEntities) {
        this.phoneNumberEntities = phoneNumberEntities;
    }
}
