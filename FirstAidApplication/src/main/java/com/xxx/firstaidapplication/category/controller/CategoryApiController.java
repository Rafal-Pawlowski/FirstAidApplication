package com.xxx.firstaidapplication.category.controller;

import com.xxx.firstaidapplication.category.domain.model.Category;
import com.xxx.firstaidapplication.category.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryApiController {

    private final CategoryService categoryService;


    public CategoryApiController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping
    Page<Category> getCategories(Pageable pageable){
        return categoryService.getCategories(pageable);
    }

    @GetMapping("{category-id}")
    Category getCategory(@PathVariable("category-id")UUID categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PutMapping("{category-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Category updateCategory(@PathVariable("category-id")UUID categoryId, @RequestBody Category category){
        return categoryService.updateCategory(categoryId, category);
    }


    @DeleteMapping("category-id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(@PathVariable("category-id") UUID categoryId){
        categoryService.deleteCategory(categoryId);

    }

}
