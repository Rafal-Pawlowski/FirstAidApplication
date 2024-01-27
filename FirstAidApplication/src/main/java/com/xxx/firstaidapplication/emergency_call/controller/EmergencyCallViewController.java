package com.xxx.firstaidapplication.emergency_call.controller;

import com.xxx.firstaidapplication.category.service.CategoryService;
import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import com.xxx.firstaidapplication.emergency_call.service.EmergencyCallService;
import com.xxx.firstaidapplication.emergency_call.service.InstructionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/emergency-calls")
public class EmergencyCallViewController {

    private final EmergencyCallService emergencyCallService;
    private final InstructionService instructionService;
    private final CategoryService categoryService;

    public EmergencyCallViewController(EmergencyCallService emergencyCallService, InstructionService instructionService, CategoryService categoryService) {
        this.emergencyCallService = emergencyCallService;
        this.instructionService = instructionService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String indexView(Model model) {
        model.addAttribute("emergencyCalls", emergencyCallService.getEmergencyCalls());
        model.addAttribute("categories", categoryService.getCategories());

        return "emergency-call/index";
    }

    @GetMapping("{id}")
    public String singleView(Model model, @PathVariable UUID id) {
        model.addAttribute("emergencyCall", emergencyCallService.getEmergencyCall(id));
        model.addAttribute("instructions", instructionService.getInstructions(id));
        model.addAttribute("categories", categoryService.getCategories());

        return "emergency-call/single";
    }

    @GetMapping("add")
    public String addView(Model model) {
        model.addAttribute("emergencyCall", new EmergencyCall());

        return "emergency-call/add";
    }

    @PostMapping
    public String add(EmergencyCall emergencyCall) {
        emergencyCallService.createEmergencyCall(emergencyCall);

        return "redirect:/emergency-calls";
    }


}
