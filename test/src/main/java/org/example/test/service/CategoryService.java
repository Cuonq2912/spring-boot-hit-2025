package org.example.test.service;


import org.example.test.domain.dto.CategoryCreateDto;
import org.example.test.domain.dto.CategoryDto;
import org.example.test.domain.dto.CategoryUpdateDto;
import org.example.test.domain.dto.response.CommonResponseDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategory();
    CategoryDto getCategoryById(Long id);
    CategoryDto createCategory(CategoryCreateDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryUpdateDto categoryDto);
    CommonResponseDto deleteCategory(Long id);

}
