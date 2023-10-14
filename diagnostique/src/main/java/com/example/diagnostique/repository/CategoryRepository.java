package com.example.diagnostique.repository;

import com.example.diagnostique.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}

