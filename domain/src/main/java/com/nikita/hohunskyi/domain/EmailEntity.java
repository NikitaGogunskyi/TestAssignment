package com.nikita.hohunskyi.domain;

import javax.persistence.*;
import java.util.Set;

@Table(name = "emails")
@Entity
public class EmailEntity extends AbstractEntity {

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "email", fetch = FetchType.LAZY)
    private Set<ContactEmailEntity> contactEmailEntities;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ContactEmailEntity> getContactEmailEntities() {
        return contactEmailEntities;
    }

    public void setContactEmailEntities(Set<ContactEmailEntity> contactEmailEntities) {
        this.contactEmailEntities = contactEmailEntities;
    }
}
