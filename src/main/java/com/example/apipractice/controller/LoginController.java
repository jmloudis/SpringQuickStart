package com.example.apipractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {


    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {

        if (request.isUserInRole("ROLE_ADMIN")) {
            return "admin/admin-index";
        }
        return "index";



    }
}
