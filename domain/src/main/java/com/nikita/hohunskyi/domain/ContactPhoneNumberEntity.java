package com.nikita.hohunskyi.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "contact_phone_numbers")
@Entity
public class ContactPhoneNumberEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private ContactEntity contact;

    @ManyToOne
    @JoinColumn(name = "number_id", nullable = false)
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
