package com.example.contactProject.service;

import com.example.contactProject.controller.dto.CreateContact;
import com.example.contactProject.repository.ContactRepository;
import com.example.contactProject.repository.entity.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void createContact(CreateContact createContact) {

        Contact contact = new Contact();

        contact.setName(createContact.getName());
        contact.setFirstname(createContact.getFirstname());
        contact.setCompany(createContact.getCompany());
        contact.setPosition(createContact.getPosition());
        contact.setEmail(contact.getEmail());
        contact.setPhone(contact.getPhone());
        contact.setBirthdate(contact.getBirthdate());
        contact.setNotes(contact.getNotes());
        contact.setUser(contact.getUser());

        contactRepository.save(contact);
    }
}
