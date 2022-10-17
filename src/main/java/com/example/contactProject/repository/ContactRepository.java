package com.example.contactProject.repository;

import com.example.contactProject.repository.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
