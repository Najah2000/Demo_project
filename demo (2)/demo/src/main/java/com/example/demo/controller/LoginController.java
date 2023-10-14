package com.example.demo.controller;


import com.example.demo.model.login;
import com.example.demo.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping("question")

public class LoginController {
    @Autowired
    private LoginService userService;

    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new login());
        return mav;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@ModelAttribute("user") login user) {

        login oauthUser = userService.login(user.getUsername(), user.getPassword());

        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            // Authentification réussie
            return ResponseEntity.ok("Authentification réussie.");
        } else {
            // Authentification échouée
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentification échouée.");
        }
    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public ResponseEntity<String> logoutDo(HttpServletRequest request, HttpServletResponse response) {


        return ResponseEntity.ok("Déconnexion réussie.");    }
}

