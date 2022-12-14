package com.example.contactProject.controller;

import com.example.contactProject.controller.dto.CreateContact;
import com.example.contactProject.repository.entity.Contact;
import com.example.contactProject.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String displayAllContacts(Model model, @RequestParam(value = "search", required = false) String searchValue) {
        if (searchValue != null) {
            List<Contact> contactList = contactService.getContactByKeywords(searchValue, searchValue);
            model.addAttribute("contacts", contactList);
        } else {
            List<Contact> contactList = contactService.getAllContacts();
            model.addAttribute("contacts", contactList);
        }
        return "contactsListView";
    }

    @GetMapping("/details/{id}")
    public String displaySpecificContact(@PathVariable("id") long id, Model model) {
        Contact contact = contactService.getSpecificContact(id);
        model.addAttribute("contact", contact);
        return "contactDetails";
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

    @GetMapping("/edit/{id}")
    public String editContactForm(@PathVariable("id") long id, Model model) {
        Contact contact = contactService.getSpecificContact(id);
        model.addAttribute("contact", contact);
        return "editContactForm";
    }

    @PostMapping("/edit/{id}")
    public RedirectView editContact(@PathVariable("id") long id, CreateContact editContact) {
        contactService.editContact(id, editContact);
        return new RedirectView("/contacts/details/{id}");
    }

    /*@GetMapping("/delete/{id}")
    public String deleteContactModal(@PathVariable("id") long id, Model model) {
        Contact contact = contactService.getSpecificContact(id);
        model.addAttribute("contact", contact);
        return "deleteContactModal";
    }*/

    @PostMapping("/delete/{id}")
    public RedirectView deleteContact(@PathVariable("id") long id) {
        contactService.deleteContact(id);
        return new RedirectView("/contacts/all");
    }

}
