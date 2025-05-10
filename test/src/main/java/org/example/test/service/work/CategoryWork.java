package org.example.test.service.work;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.test.constant.CommonConstant;
import org.example.test.constant.CommonMessage;
import org.example.test.constant.ErrorMessage;
import org.example.test.domain.dto.*;
import org.example.test.domain.dto.response.CommonResponseDto;
import org.example.test.domain.entity.Category;
import org.example.test.domain.mapper.CategoryMapper;
import org.example.test.exception.NotFoundException;
import org.example.test.repository.CategoryRepository;
import org.example.test.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryWork implements CategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCategoryDto).toList();
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        checkCategoryNotFound(category, id);
        return categoryMapper.toCategoryDto(category.get());
    }

    @Override
    public CategoryDto createCategory(CategoryCreateDto categoryDto) {
        Category category = categoryMapper.toCategory(categoryDto);
        return categoryMapper.toCategoryDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryUpdateDto categoryDto) {
        Optional<Category> category = categoryRepository.findById(id);
        checkCategoryNotFound(category, id);
        categoryMapper.updateCategoryFromDto(categoryDto, category.get());
        return categoryMapper.toCategoryDto(categoryRepository.save(category.get()));
    }

    @Override
    public CommonResponseDto deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        checkCategoryNotFound(category, id);
        categoryRepository.delete(category.get());
        return new CommonResponseDto(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }


    private void checkCategoryNotFound(Optional<Category> category, Long id) {
        if(category.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Category.ERR_NOT_FOUND_ID, id));
        }
    }
}
