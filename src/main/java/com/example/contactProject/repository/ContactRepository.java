package com.example.contactProject.repository;

import com.example.contactProject.controller.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
