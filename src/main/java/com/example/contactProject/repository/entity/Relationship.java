package com.example.contactProject.repository.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "relationship", schema = "contacts", catalog = "")
public class Relationship {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "relationship", nullable = false, length = 50)
    private String relationship;
    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id", nullable = false)
    private Contact contact;
    @ManyToOne
    @JoinColumn(name = "id_relationship", referencedColumnName = "id", nullable = false)
    private Contact contactRelationship;

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relationship that = (Relationship) o;
        return id == that.id && Objects.equals(relationship, that.relationship) && Objects.equals(contact, that.contact) && Objects.equals(contactRelationship, that.contactRelationship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, relationship, contact, contactRelationship);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContactRelationship() {
        return contactRelationship;
    }

    public void setContactRelationship(Contact contactRelationship) {
        this.contactRelationship = contactRelationship;
    }
}
