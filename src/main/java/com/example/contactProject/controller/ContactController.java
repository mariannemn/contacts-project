package com.example.contactProject.controller;

import com.example.contactProject.controller.dto.CreateContact;
import com.example.contactProject.repository.entity.Contact;
import com.example.contactProject.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public String displayAllContacts(Model model) {
        List<Contact> contactList = contactService.getAllContacts();
        model.addAttribute("contacts", contactList);
        return "contactsListView";
    }

    @GetMapping("/add")
    public String createContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "createContactForm";
    }

    @PostMapping("/add")
    public RedirectView createContact(CreateContact createContact) {
        contactService.createContact(createContact);
        return new RedirectView("/contacts/all");
    }
}
