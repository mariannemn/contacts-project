package com.example.contactProject.repository;

import com.example.contactProject.repository.entity.Contact;
import com.example.contactProject.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    Contact findByIdAndUser(long id, User user);

    List<Contact> findAllByUser(User user);

    List<Contact> findContactByNameEqualsAndUserOrFirstnameEqualsAndUser(String name, User user1, String firstname, User user2);
}
