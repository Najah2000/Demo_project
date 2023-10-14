package com.example.demo.dao;



import com.example.demo.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userRepos extends JpaRepository<user,Long> {
}
