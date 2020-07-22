package com.nikita.hohunskyi.domain.dto;

import com.nikita.hohunskyi.domain.constant.ErrorMessages;
import com.nikita.hohunskyi.domain.constant.RegexConstants;
import com.nikita.hohunskyi.domain.dto.validation.annotation.PatternInCollection;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class ContactDto {

    @NotNull
    private String name;

    @NotNull
    @PatternInCollection(regexp = RegexConstants.EMAIL, message = ErrorMessages.INCORRECT_USER_EMAIL)
    private Set<String> emails;

    @NotNull
    @Size(min = 1)
    @PatternInCollection(regexp = RegexConstants.PHONE_NUMBER, message = ErrorMessages.INCORRECT_PHONE_NUMBER)
    private Set<String> numbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public Set<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactDto that = (ContactDto) o;
        return new EqualsBuilder()
                .append(name, that.name)
                .append(emails, that.emails)
                .append(numbers, that.numbers)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("emails", emails)
                .append("phone numbers", numbers)
                .toString();
    }
}
