package org.example.test.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.test.base.RestApiV1;
import org.example.test.base.VsResponseUtil;
import org.example.test.constant.UrlConstant;
import org.example.test.domain.dto.CategoryCreateDto;
import org.example.test.domain.dto.CategoryUpdateDto;
import org.example.test.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class    CategoryController {

    CategoryService categoryService;

    @GetMapping(UrlConstant.Category.GET_CATEGORIES)
    public ResponseEntity<?> getAllCategory(){
        return VsResponseUtil.ok(categoryService.getAllCategory());
    }

    @GetMapping(UrlConstant.Category.CREATE_CATEGORY)
    public ResponseEntity<?> create(@Valid @RequestBody CategoryCreateDto categoryCreateDto){
        return VsResponseUtil.ok(categoryService.createCategory(categoryCreateDto));
    }

    @GetMapping(UrlConstant.Category.GET_CATEGORY)
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId){
        return VsResponseUtil.ok(categoryService.getCategoryById(categoryId));
    }

    @PostMapping(UrlConstant.Category.UPDATE_CATEGORY)
    public ResponseEntity<?> update(@Valid @RequestBody CategoryUpdateDto categoryUpdateDto, @PathVariable Long categoryId){
        return VsResponseUtil.ok(categoryService.updateCategory(categoryId, categoryUpdateDto));
    }

    @DeleteMapping(UrlConstant.Category.DELETE_CATEGORY)
    public ResponseEntity<?> delete(@PathVariable Long categoryId){
        return VsResponseUtil.ok(categoryService.deleteCategory(categoryId));
    }

}
