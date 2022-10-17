package com.example.contactProject.service;

import com.example.contactProject.controller.dto.CreateContact;
import com.example.contactProject.repository.ContactRepository;
import com.example.contactProject.repository.entity.Contact;
import com.example.contactProject.repository.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
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
}
