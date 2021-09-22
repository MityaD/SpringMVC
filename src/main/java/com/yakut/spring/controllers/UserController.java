package com.yakut.spring.controllers;

import com.yakut.spring.model.User;
import com.yakut.spring.repository.UserRepository;
import com.yakut.spring.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

//    private UserRepository userRepository;
//
//    @GetMapping
//    public String getUser(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
//        return "user";
//    }
}
