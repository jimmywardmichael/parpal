package com.codeup.parpal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
     @GetMapping("/login")
    public String showLoginForm(){
         return "users/login";
     }
}
