package com.example.contactProject.service;

import com.example.contactProject.controller.dto.CreateContact;
import com.example.contactProject.exceptions.ContactNotFoundException;
import com.example.contactProject.repository.ContactRepository;
import com.example.contactProject.repository.entity.Contact;
import com.example.contactProject.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return (List<Contact>) this.contactRepository.findAll();
    }

    public Contact getSpecificContact(long id) {
        Optional<Contact> contactOptional = this.contactRepository.findById(id);

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            return contact;
        } else {
            throw new ContactNotFoundException(id);
        }
    }

    public void createContact(CreateContact createContact) {

        Contact contact = new Contact();

        User user = new User();
        user.setId(1);

        contact.setName(createContact.getName());
        contact.setFirstname(createContact.getFirstname());
        contact.setCompany(createContact.getCompany());
        contact.setPosition(createContact.getPosition());
        contact.setEmail(createContact.getEmail());
        contact.setPhone(createContact.getPhone());
        contact.setBirthdate(createContact.getBirthdate());
        contact.setNotes(createContact.getNotes());

        contact.setUser(user);

        contactRepository.save(contact);
    }

    public void editContact(long id, CreateContact editContact) {
        Optional<Contact> contactOptional = this.contactRepository.findById(id);

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();

            contact.setName(editContact.getName());
            contact.setFirstname(editContact.getFirstname());
            contact.setCompany(editContact.getCompany());
            contact.setPosition(editContact.getPosition());
            contact.setEmail(editContact.getEmail());
            contact.setPhone(editContact.getPhone());
            contact.setBirthdate(editContact.getBirthdate());
            contact.setNotes(editContact.getNotes());

            contactRepository.save(contact);

        } else {
            throw new ContactNotFoundException(id);
        }
    }

    public void deleteContact(long id) {
        contactRepository.deleteById(id);
    }
}
