package com.nikita.hohunskyi.domain.dto;

import com.nikita.hohunskyi.domain.constant.ErrorMessage;
import com.nikita.hohunskyi.domain.constant.RegexConstants;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateUserDto {

    @NotNull
    @Pattern(regexp = RegexConstants.EMAIL, message = ErrorMessage.INCORRECT_USER_EMAIL)
    private String email;

    @NotNull
    @Pattern(regexp = RegexConstants.PASSWORD, message = ErrorMessage.INCORRECT_USER_PASSWORD)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPassword())
                .append(getEmail())
                .toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CreateUserDto createUserDto = (CreateUserDto) o;

        return new EqualsBuilder()
                .append(getEmail(), createUserDto.getEmail())
                .append(getPassword(), createUserDto.getPassword())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("email", email)
                .append("password", password)
                .toString();
    }
}
