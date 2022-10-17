package com.example.contactProject.repository;

import com.example.contactProject.controller.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
