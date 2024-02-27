package com.xxx.firstaidapplication.category.controller;

import com.xxx.firstaidapplication.category.domain.model.Category;
import com.xxx.firstaidapplication.category.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/categories")
public class CategoryAdminViewController {

    private final CategoryService categoryService;


    public CategoryAdminViewController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping
    public String indexView(Model model) {
        model.addAttribute("categories", categoryService.getCategories());

        return "admin/category/index";
    }
    @GetMapping("{id}")
    public String editView(Model model, @PathVariable UUID id) {
        model.addAttribute("category", categoryService.getCategory(id));

        return "admin/category/edit";
    }

    @PostMapping("{id}")
    public String edit(@ModelAttribute("category") Category category,@PathVariable UUID id){
        categoryService.updateCategory(id, category);
        return "redirect:/admin/categories";
    }

    @GetMapping("{id}/delete")
    public String deleteView(@PathVariable UUID id) {
        categoryService.deleteCategory(id);

        return "redirect:/admin/categories";
    }


}
