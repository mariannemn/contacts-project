package com.example.contactProject.repository.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "contact")
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;
    @Basic
    @Column(name = "company", nullable = false, length = 50)
    private String company;
    @Basic
    @Column(name = "position", nullable = false, length = 100)
    private String position;
    @Basic
    @Column(name = "email", nullable = false, length = 200)
    private String email;
    @Basic
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Basic
    @Column(name = "birthdate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @Basic
    @Column(name = "notes", nullable = false, length = 2000)
    private String notes;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "contact")
    private Collection<Relationship> relationshipsById;
    @OneToMany(mappedBy = "contactRelationship")
    private Collection<Relationship> relationshipsById_0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact that = (Contact) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(firstname, that.firstname) && Objects.equals(company, that.company) && Objects.equals(position, that.position) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(birthdate, that.birthdate) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstname, company, position, email, phone, birthdate, notes);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Relationship> getRelationshipsById() {
        return relationshipsById;
    }

    public void setRelationshipsById(Collection<Relationship> relationshipsById) {
        this.relationshipsById = relationshipsById;
    }

    public Collection<Relationship> getRelationshipsById_0() {
        return relationshipsById_0;
    }

    public void setRelationshipsById_0(Collection<Relationship> relationshipsById_0) {
        this.relationshipsById_0 = relationshipsById_0;
    }
}
