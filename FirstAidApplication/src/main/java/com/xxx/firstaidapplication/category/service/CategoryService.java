package com.xxx.firstaidapplication.category.service;

import com.xxx.firstaidapplication.category.model.Category;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    public Category createCategory(Category category) {
        category.setId(UUID.randomUUID());

        return category;
        
    }

    public List<Category> getCategories() {
        return Arrays.asList(
                new Category("Category"),
                new Category("Category2"),
                new Category("Category3"));
    }


    public Category getCategory(UUID categoryId) {
        return new Category("Category" + categoryId);
    }


    public Category updateCategory(UUID categoryId, Category category) {
        return category;
    }

    public void deleteCategory(UUID categoryId) {
    }
}
