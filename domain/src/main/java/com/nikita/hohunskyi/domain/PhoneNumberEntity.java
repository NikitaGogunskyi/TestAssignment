package com.nikita.hohunskyi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "phone_numbers")
@Entity
public class PhoneNumberEntity extends AbstractEntity {

    @Column(name = "number")
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
