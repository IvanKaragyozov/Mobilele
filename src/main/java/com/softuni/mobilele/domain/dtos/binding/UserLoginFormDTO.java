package com.softuni.mobilele.domain.dtos.binding;

import com.softuni.mobilele.validations.userExists.ValidateLoginUser;

@ValidateLoginUser
public class UserLoginFormDTO {

    private String username;
    private String password;

    public UserLoginFormDTO() {
    }

    public UserLoginFormDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public UserLoginFormDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginFormDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
