package com.nikita.hohunskyi.domain.dto;

import com.nikita.hohunskyi.domain.constant.ErrorMessages;
import com.nikita.hohunskyi.domain.constant.RegexConstants;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserCredentialsDto {

    @NotNull
    @Pattern(regexp = RegexConstants.EMAIL, message = ErrorMessages.INCORRECT_USER_EMAIL)
    private String username;

    @NotNull
    @Pattern(regexp = RegexConstants.PASSWORD, message = ErrorMessages.INCORRECT_USER_PASSWORD)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                .append(getUsername())
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

        UserCredentialsDto userCredentialsDto = (UserCredentialsDto) o;

        return new EqualsBuilder()
                .append(getUsername(), userCredentialsDto.getUsername())
                .append(getPassword(), userCredentialsDto.getPassword())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("email", username)
                .append("password", password)
                .toString();
    }
}
