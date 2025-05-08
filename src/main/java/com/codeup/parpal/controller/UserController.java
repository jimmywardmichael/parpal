package com.codeup.parpal.controller;

import com.codeup.parpal.models.Event;
import com.codeup.parpal.models.User;
import com.codeup.parpal.services.UserDaoService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class UserController {
    private final UserDaoService userDao;

    public UserController(UserDaoService userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        userDao.registerUser(user);
        return "redirect:/login";
    }

    //Edit User
    @GetMapping("/users/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        User userToUpdate = userDao.getUserById(id);
        model.addAttribute("user", userToUpdate);
        return "users/edit";
    }


    //Display edited User
    @PostMapping("/users/{id}/edit")
    public String submitUserChanges(@ModelAttribute User user) {
        userDao.saveUser(user);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User updatedUser = userDao.getUserById(loggedInUser.getId());
        model.addAttribute("user", updatedUser);
        return "users/profile";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable long id) {
        userDao.deleteUserById(id);
        return "redirect:/login";
    }

    @GetMapping("/users/all-users")
    public String showAllUsers(Model model){
        List<User> users = userDao.findAllUsers();
        model.addAttribute("allUsers", users);
        return "users/all-users";
    }

}

