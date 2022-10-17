package com.example.contactProject.controller;

import com.example.contactProject.controller.dto.CreateUser;
import com.example.contactProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String displaySignUpForm(Model model) {
        model.addAttribute("createUser", new CreateUser());
        return "signUpFormView";
    }

    @PostMapping("/signup")
    public String signUp(@Valid CreateUser createUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("createUser", createUser);
            return "signUpFormView";
        } else {
            userService.register(createUser);
            return "redirect:/signin";
        }
    }

    @GetMapping("/signin")
    public String displaySignInForm(Model model, CreateUser user) {
        model.addAttribute("user", user);
        return "signInForm";
    }
}
