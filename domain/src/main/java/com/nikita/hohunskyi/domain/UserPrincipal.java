package com.nikita.hohunskyi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.security.Principal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPrincipal implements Principal, Serializable {

    @JsonProperty("id")
    private String userId;

    @JsonProperty("email")
    private String email;

    private Role role;

    @JsonIgnore
    private transient String accessToken;

    public UserPrincipal(UserEntity userEntity) {
        this.userId = userEntity.getId();
        this.email = userEntity.getEmail();
        this.role = userEntity.getRole();
    }

    public UserPrincipal() {
        //default constructor
    }

    @Override
    public String getName() {
        return email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String  userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userId)
                .append(email)
                .append(role)
                .append(accessToken)
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
        UserPrincipal that = (UserPrincipal) o;
        return new EqualsBuilder()
                .append(userId, that.userId)
                .append(email, that.email)
                .append(role, that.role)
                .append(accessToken, that.accessToken)
                .isEquals();
    }
}
