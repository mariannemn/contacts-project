package com.example.contactProject.controller.dto;


import javax.validation.constraints.*;

public class CreateUser {

    @NotEmpty(message = "Le nom n'est pas défini")
    private String name;

    @NotEmpty(message = "Le prénom n'est pas défini")
    private String firstname;

    //@NotEmpty(message = "La photo n'est pas définie")
    private String photo;

    @NotEmpty(message = "L'e-mail n'est pas défini")
    @Email(message = "Le-mail doit être valide")
    private String email;

    @NotNull
    @Size(min = 5, message = "Le mot de passe doit contenir au minimum 5 caractères")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
