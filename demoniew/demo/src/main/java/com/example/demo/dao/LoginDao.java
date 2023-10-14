package com.example.demo.dao;

import com.example.demo.model.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface LoginDao  extends JpaRepository<login, Long>{
    login findByUsernameAndPassword(String username, String password);

}
