package com.xxx.firstaidapplication.category.controller;

import com.xxx.firstaidapplication.category.domain.model.Category;
import com.xxx.firstaidapplication.category.service.CategoryService;
import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import com.xxx.firstaidapplication.emergency_call.service.EmergencyCallService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryViewController {

    private final CategoryService categoryService;
    private final EmergencyCallService emergencyCallService;

    public CategoryViewController(CategoryService categoryService, EmergencyCallService emergencyCallService) {
        this.categoryService = categoryService;
        this.emergencyCallService = emergencyCallService;
    }

    @GetMapping("{id}")
    public String singleView(@PathVariable UUID id, Model model) {
        Category category = categoryService.getCategory(id);
        List<EmergencyCall> emergencyCalls = emergencyCallService.findAllEmergencyCallsByCategoryId(id);

        model.addAttribute("category", category);
        model.addAttribute("emergencycalls", emergencyCalls);

        return "category/single";
    }


}

