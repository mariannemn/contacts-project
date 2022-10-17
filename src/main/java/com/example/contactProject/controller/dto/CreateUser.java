package com.example.contactProject.controller.dto;


import javax.validation.constraints.*;

public class CreateUser {

    @NotEmpty(message = "Email is null")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull
    @Size(min = 5, message = "Password must be a minimum of 5 characters in length")
    private String password;

    public CreateUser() {
    }

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
}
