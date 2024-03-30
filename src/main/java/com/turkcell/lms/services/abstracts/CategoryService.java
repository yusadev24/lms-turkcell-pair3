package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAll();

    Category addCategory(Category category);

    void deleteCategoryById(int id);

    Optional<Category> getById(int id);

    Category updateCategory(int id, Category category);
}
