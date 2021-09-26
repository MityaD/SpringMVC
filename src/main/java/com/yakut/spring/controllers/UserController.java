package com.yakut.spring.controllers;

import com.yakut.spring.exception.NoUserTableException;
import com.yakut.spring.model.Address;
import com.yakut.spring.model.User;
import com.yakut.spring.service.AddressService;
import com.yakut.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    private UserService userService;
    private AddressService addressService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> allUser = userService.findAllUser();
        model.addAttribute("allUser", allUser);
        return "user";
    }

    @GetMapping("/address")
    public String getAddress(Model model, @RequestParam Long id) throws NoUserTableException {
        User addressById = userService.findUserById(id);
        model.addAttribute("addressById" , addressById);
        return "address";
    }

    @GetMapping(value = "/add")
    public String getPageSave(Model model, User user) {
        model.addAttribute(user);
        return "userForm";
    }

    @GetMapping("/updateForm")
    public String updateForm(Model model, @RequestParam Long id) throws NoUserTableException {
        model.addAttribute(userService.findUserById(id));
        return "userForm";
    }

    @PostMapping
    public String updateUser(@RequestParam (required = false) Long  id, @RequestParam String firstName,
                             @RequestParam String lastName, @RequestParam int age,
                             @RequestParam (name = "address.city") String city,
                             @RequestParam (name = "address.street") String street,
                             @RequestParam (name = "address.house") String house) {
        User user = new User(id, firstName, lastName, age, new Address(city, street, house));
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }
}
