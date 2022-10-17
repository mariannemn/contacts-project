package com.example.contactProject.repository;

import com.example.contactProject.repository.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findContactByNameEqualsOrFirstnameEquals(String name, String firstname);
}
