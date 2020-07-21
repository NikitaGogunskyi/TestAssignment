package com.nikita.hohunskyi.domain;

import javax.persistence.*;
import java.util.Set;

@Table(name = "phone_numbers")
@Entity
public class PhoneNumberEntity extends AbstractEntity {

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "number", fetch = FetchType.LAZY)
    private Set<ContactPhoneNumberEntity> contactPhoneNumberEntities;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<ContactPhoneNumberEntity> getContactPhoneNumberEntities() {
        return contactPhoneNumberEntities;
    }

    public void setContactPhoneNumberEntities(Set<ContactPhoneNumberEntity> contactPhoneNumberEntities) {
        this.contactPhoneNumberEntities = contactPhoneNumberEntities;
    }
}
