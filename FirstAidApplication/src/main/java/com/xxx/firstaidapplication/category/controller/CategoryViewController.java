package com.xxx.firstaidapplication.category.controller;

import com.xxx.firstaidapplication.category.domain.model.Category;
import com.xxx.firstaidapplication.category.service.CategoryService;
import com.xxx.firstaidapplication.common.controller.FirstAidCommonViewController;
import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import com.xxx.firstaidapplication.emergency_call.service.EmergencyCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryViewController extends FirstAidCommonViewController {

    private final CategoryService categoryService;
    private final EmergencyCallService emergencyCallService;

    @GetMapping("{id}")
    public String singleView(@PathVariable UUID id, Model model) {
        Category category = categoryService.getCategory(id);
        List<EmergencyCall> emergencyCalls = emergencyCallService.findAllEmergencyCallsByCategoryId(id);

        model.addAttribute("category", category);
        model.addAttribute("emergencycalls", emergencyCalls);
        addGlobalAttributes(model);

        return "category/single";
    }


}

