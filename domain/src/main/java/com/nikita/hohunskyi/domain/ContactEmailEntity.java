package com.nikita.hohunskyi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "contact_emails")
@Entity
public class ContactEmailEntity extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    private ContactEntity contact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id")
    private EmailEntity email;

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contactEntity) {
        this.contact = contactEntity;
    }

    public EmailEntity getEmail() {
        return email;
    }

    public void setEmail(EmailEntity emailEntity) {
        this.email = emailEntity;
    }
}
