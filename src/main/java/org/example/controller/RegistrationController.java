package org.example.controller;

import org.example.domain.User;
import org.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user,
                          Model model) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB == null) {
            userRepo.save(user);
            return "redirect:login";
        }
        return "registration";
    }

}


