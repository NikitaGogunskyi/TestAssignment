package com.nikita.hohunskyi.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "contact_emails")
@Entity
public class ContactEmailEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private ContactEntity contact;

    @ManyToOne
    @JoinColumn(name = "email_id", nullable = false)
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
