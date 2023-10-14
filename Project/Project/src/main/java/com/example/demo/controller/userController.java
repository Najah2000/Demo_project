package com.example.demo.controller;

import com.example.demo.dao.userRepos;
import com.example.demo.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class userController{
    @Autowired
    userRepos userRepos;
    @PostMapping("/Login")
    public String auth(@ModelAttribute user user){
        List<user> u = userRepos.findAll();
        String test = "";
        for (int i=0;i<u.size();i++){
            if(u.get(i).getUsername().equals(user.getUsername()) && u.get(i).getPassword().equals(user.getPassword()))
                test = "success";

            else;

        }
        if(test == "success") return " valide";
        else return "Oechoue";
    }
}
