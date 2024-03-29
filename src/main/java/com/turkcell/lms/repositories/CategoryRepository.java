package com.turkcell.lms.repositories;


import com.turkcell.lms.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}