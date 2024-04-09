package com.turkcell.lms.repositories;


import com.turkcell.lms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    // Derived Query Methods
    Optional<Category> findByNameIgnoreCase(String name);
}