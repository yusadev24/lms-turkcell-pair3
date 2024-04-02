package com.turkcell.lms.services.abstracts;

import com.turkcell.lms.dtos.requests.category.AddCategoryRequest;
import com.turkcell.lms.dtos.requests.category.UpdateCategoryRequest;
import com.turkcell.lms.dtos.responses.category.AddCategoryResponse;
import com.turkcell.lms.dtos.responses.category.GetByIdCategoryResponse;
import com.turkcell.lms.dtos.responses.category.ListCategoryResponse;
import com.turkcell.lms.dtos.responses.category.UpdateCategoryResponse;
import com.turkcell.lms.dtos.responses.member.GetByIdMemberResponse;
import com.turkcell.lms.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<ListCategoryResponse> getAll();

    AddCategoryResponse addCategory(AddCategoryRequest request);

    void deleteCategoryById(int id);

    Optional<GetByIdCategoryResponse> getById(int id);

    UpdateCategoryResponse updateCategory(int id, UpdateCategoryRequest request);
}
