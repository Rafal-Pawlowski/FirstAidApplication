package com.xxx.firstaidapplication.emergency_call.controller;

import com.xxx.firstaidapplication.emergency_call.domain.model.Category;
import com.xxx.firstaidapplication.emergency_call.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/emergency-calls/category")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping
    List<Category> getCategories(){
        return categoryService.getCategories();
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
