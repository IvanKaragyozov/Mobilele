package com.softuni.mobilele.domain.dtos.banding;

public class UserRegisterFormDTO {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String role;

    public String getUsername() {
        return username;
    }

    public UserRegisterFormDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterFormDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterFormDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterFormDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRegisterFormDTO setRole(String role) {
        this.role = role;
        return this;
    }
}
