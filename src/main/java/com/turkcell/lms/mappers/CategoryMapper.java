package com.turkcell.lms.mappers;

import com.turkcell.lms.dtos.requests.category.AddCategoryRequest;
import com.turkcell.lms.dtos.requests.category.UpdateCategoryRequest;
import com.turkcell.lms.dtos.responses.category.GetByIdCategoryResponse;
import com.turkcell.lms.dtos.responses.category.ListCategoryResponse;
import com.turkcell.lms.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);

   // @Mapping(target = "name", source = "name") // isimler farklı olursa kullanılır
   // @Mapping(source = "categoryId", target = "category.id")
    Category categoryFromRequest(AddCategoryRequest request);

    Category updateCategoryFromRequest(UpdateCategoryRequest request,
                                       @MappingTarget Category category);

    List<ListCategoryResponse> categoriesToResponseList(List<Category> categories);

    GetByIdCategoryResponse categoryToResponse(Category category);

}
