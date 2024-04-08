package com.turkcell.lms.services.concretes;

import com.turkcell.lms.entities.Category;
import com.turkcell.lms.repositories.CategoryRepository;
import com.turkcell.lms.services.abstracts.CategoryService;
import com.turkcell.lms.services.dtos.requests.category.AddCategoryRequest;
import com.turkcell.lms.services.dtos.requests.category.UpdateCategoryRequest;
import com.turkcell.lms.services.dtos.responses.category.AddCategoryResponse;
import com.turkcell.lms.services.dtos.responses.category.GetByIdCategoryResponse;
import com.turkcell.lms.services.dtos.responses.category.ListCategoryResponse;
import com.turkcell.lms.services.dtos.responses.category.UpdateCategoryResponse;
import com.turkcell.lms.services.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public List<ListCategoryResponse> getAll() {

        List<Category> categories = categoryRepository.findAll();
        return CategoryMapper.INSTANCE.categoriesToResponseList(categories);

    }

    @Override
    public List<Category> getAllCategoryEntities(List<Integer> ids) {
        return categoryRepository.findAllById(ids);
    }


    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest request) {
        Category category= CategoryMapper.INSTANCE.categoryFromRequest(request);
        Category savedCategory=categoryRepository.save(category);

        AddCategoryResponse response= new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
        return response;
    }

    @Override
    public void deleteCategoryById(int id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Category with ID " + id + " does not exist");
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<GetByIdCategoryResponse> getById(int id) {
        Optional<Category> categoryOptional=categoryRepository.findById(id);

        if(categoryOptional.isEmpty()){
            throw new RuntimeException("Category not found with id: " + id);
        }

        return categoryOptional.map(CategoryMapper.INSTANCE::categoryToResponse);
    }

    @Override
    public Optional<Category> findEntityById(Integer id){
        return categoryRepository.findById(id);
    }
    @Override
    public UpdateCategoryResponse updateCategory(int id, UpdateCategoryRequest request) {

        Optional<Category> existingCategoryO= categoryRepository.findById(id);
        if(existingCategoryO==null){
            throw new RuntimeException("Category not found with id: " + id);
        }

        Category existingCategory = existingCategoryO.get();

        Category category= CategoryMapper.INSTANCE.updateCategoryFromRequest(request,existingCategory);
        Category savedCategory=categoryRepository.save(category);

        UpdateCategoryResponse response= new UpdateCategoryResponse(savedCategory.getId(), savedCategory.getName());
        return response;
    }
}
