package com.example.apipractice.controller;

import com.example.apipractice.model.User;
import com.example.apipractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    // Method returns login.html when called
    @GetMapping("/login")
    public String login(){

        return "login";

    }

    // Adds new User to the Model class
    @GetMapping("/userRegister")
    public String userRegister(Model model){

        User user = new User();
        model.addAttribute("user", user);
        return "registration";

    }

    // Saves new User to the database
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){



        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "redirect:login";

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "user/logout";
    }
}
