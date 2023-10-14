package com.example.demo.dao;

import com.example.demo.model.quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<quiz, Integer> {
}