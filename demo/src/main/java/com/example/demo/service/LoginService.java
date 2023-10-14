package com.example.demo.service;

import com.example.demo.dao.LoginDao;
import com.example.demo.model.login;
import com.example.demo.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginDao repo;

    public login login(String username, String password) {
        login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }
}
