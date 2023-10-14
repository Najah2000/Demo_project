package com.example.demo.dao;

import com.example.demo.model.categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<categorie, Integer> {
}