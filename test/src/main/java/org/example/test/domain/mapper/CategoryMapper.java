package org.example.test.domain.mapper;

import org.example.test.domain.dto.CategoryCreateDto;
import org.example.test.domain.dto.CategoryDto;
import org.example.test.domain.dto.CategoryUpdateDto;
import org.example.test.domain.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category toCategory(CategoryCreateDto categoryDto);
    CategoryDto toCategoryDto(Category category);
    void updateCategoryFromDto(CategoryUpdateDto categoryUpdateDto, @MappingTarget Category category);
}
