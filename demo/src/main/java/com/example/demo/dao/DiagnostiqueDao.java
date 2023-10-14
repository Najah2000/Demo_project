package com.example.demo.dao;

import com.example.demo.model.diagnostique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnostiqueDao extends JpaRepository<diagnostique, Integer> {
}