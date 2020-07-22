package com.nikita.hohunskyi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "contact_phone_numbers")
@Entity
public class ContactPhoneNumberEntity extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    private ContactEntity contact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "number_id")
    private PhoneNumberEntity number;

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public PhoneNumberEntity getNumber() {
        return number;
    }

    public void setNumber(PhoneNumberEntity number) {
        this.number = number;
    }
}
