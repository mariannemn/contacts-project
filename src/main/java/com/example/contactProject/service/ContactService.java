package com.example.contactProject.service;

import com.example.contactProject.controller.dto.CreateContact;
import com.example.contactProject.exceptions.ContactNotFoundException;
import com.example.contactProject.repository.ContactRepository;
import com.example.contactProject.repository.entity.Contact;
import com.example.contactProject.repository.entity.User;
import com.example.contactProject.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        User connectedUser = customUser.getUser();

        return this.contactRepository.findAllByUser(connectedUser);
    }

    public Contact getSpecificContact(long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        User connectedUser = customUser.getUser();

        Optional<Contact> contactOptional = Optional.ofNullable(this.contactRepository.findByIdAndUser(id, connectedUser));

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            return contact;
        } else {
            throw new ContactNotFoundException(id);
        }
    }

    public List<Contact> getContactByKeywords(String name, String firstname) { // search by name or firstname
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        User connectedUser = customUser.getUser();

        return this.contactRepository.findContactByNameEqualsAndUserOrFirstnameEqualsAndUser(name, connectedUser, firstname, connectedUser);
    }

    public void createContact(CreateContact createContact) {

        Contact contact = new Contact();

        User user = new User();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        User connectedUser = customUser.getUser();
        user.setId(connectedUser.getId());

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
