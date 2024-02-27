package com.xxx.firstaidapplication.category.service;

import com.xxx.firstaidapplication.category.domain.model.Category;
import com.xxx.firstaidapplication.category.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category createCategory(Category categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());

        return categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category getCategory(UUID categoryId) {
        return categoryRepository.getById(categoryId);
    }


    @Transactional
    public Category updateCategory(UUID categoryId, Category categoryRequest) {
        Category category= categoryRepository.getById(categoryId);
        category.setName(categoryRequest.getName());

        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
