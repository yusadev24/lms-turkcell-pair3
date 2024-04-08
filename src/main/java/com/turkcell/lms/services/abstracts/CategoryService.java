package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.entities.Category;
import com.turkcell.lms.services.dtos.requests.category.AddCategoryRequest;
import com.turkcell.lms.services.dtos.requests.category.UpdateCategoryRequest;
import com.turkcell.lms.services.dtos.responses.category.AddCategoryResponse;
import com.turkcell.lms.services.dtos.responses.category.GetByIdCategoryResponse;
import com.turkcell.lms.services.dtos.responses.category.ListCategoryResponse;
import com.turkcell.lms.services.dtos.responses.category.UpdateCategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<ListCategoryResponse> getAll();
    List<Category> getAllCategoryEntities(List<Integer> ids);

    AddCategoryResponse addCategory(AddCategoryRequest request);

    void deleteCategoryById(int id);

    Optional<GetByIdCategoryResponse> getById(int id);

    UpdateCategoryResponse updateCategory(int id, UpdateCategoryRequest request);

    Optional<Category> findEntityById(Integer id);
}
