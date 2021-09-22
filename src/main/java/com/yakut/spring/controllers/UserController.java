package com.yakut.spring.controllers;

import com.yakut.spring.exception.NoUserTableException;
import com.yakut.spring.model.Address;
import com.yakut.spring.model.User;
import com.yakut.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/controller")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> allUser = userService.findAllUser();
        model.addAttribute("allUser", allUser);
        return "user";
    }

    @GetMapping("/updateForm")
    public String updateForm(Model model, @RequestParam Long id) throws NoUserTableException {
        model.addAttribute(userService.findUserById(id));
        return "userForm";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam Long id, @RequestParam String firstName,
                             @RequestParam String lastName, @RequestParam int age,
                             @RequestParam Long idAd, @RequestParam String city,
                             @RequestParam String street, @RequestParam String house) {
        User user = new User(id, firstName, lastName, age, new Address(idAd, city, street, house));
        userService.save(user);
        return "user";
    }
}
