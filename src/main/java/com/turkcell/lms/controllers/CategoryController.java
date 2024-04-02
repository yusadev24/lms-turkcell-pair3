package com.turkcell.lms.controllers;

import com.turkcell.lms.dtos.requests.category.AddCategoryRequest;
import com.turkcell.lms.dtos.requests.category.UpdateCategoryRequest;
import com.turkcell.lms.dtos.responses.category.AddCategoryResponse;
import com.turkcell.lms.dtos.responses.category.ListCategoryResponse;
import com.turkcell.lms.dtos.responses.category.UpdateCategoryResponse;
import com.turkcell.lms.entities.Category;
import com.turkcell.lms.services.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories/")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @GetMapping()
    public List<ListCategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Category> getCategoryById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<AddCategoryResponse> addCategory(@RequestBody AddCategoryRequest request) {
       AddCategoryResponse response=categoryService.addCategory(request);
        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("{id}")
    public UpdateCategoryResponse updateCategory(@PathVariable int id, @RequestBody UpdateCategoryRequest category) {
        return categoryService.updateCategory(id, category);


    }

}
