package com.xxx.firstaidapplication.emergency_call.controller;

import com.xxx.firstaidapplication.FirstAidConfiguration;
import com.xxx.firstaidapplication.category.service.CategoryService;
import com.xxx.firstaidapplication.common.controller.ControllerUtils;
import com.xxx.firstaidapplication.common.controller.FirstAidCommonViewController;
import com.xxx.firstaidapplication.emergency_call.domain.model.EmergencyCall;
import com.xxx.firstaidapplication.emergency_call.service.EmergencyCallService;
import com.xxx.firstaidapplication.emergency_call.service.InstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/emergency-calls")
@RequiredArgsConstructor
public class EmergencyCallViewController extends FirstAidCommonViewController {

    private final EmergencyCallService emergencyCallService;
    private final InstructionService instructionService;
    private final CategoryService categoryService;
    private final FirstAidConfiguration firstAidConfiguration;

    @GetMapping
    public String indexView(Model model) {
        model.addAttribute("emergencyCalls", emergencyCallService.getEmergencyCalls());
        addGlobalAttributes(model);

        return "index/index";
    }

    @GetMapping("{id}")
    public String singleView(Model model, @PathVariable UUID id) {
        model.addAttribute("emergencyCall", emergencyCallService.getEmergencyCall(id));
        model.addAttribute("instructions", instructionService.getInstructions(id));
        model.addAttribute("categories", categoryService.getCategories(Pageable.unpaged()));

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

    @GetMapping("top")
    public String hotView(
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model) {
        PageRequest pageRequest = PageRequest.of(page-1, firstAidConfiguration.getPagingPageSize());
        Page<EmergencyCall> emergencyCallsPage = emergencyCallService.findTop(pageRequest);

        model.addAttribute("emergencyCallsPage", emergencyCallsPage);
        ControllerUtils.paging(model,emergencyCallsPage);
        addGlobalAttributes(model);

        return "emergency-call/index";
    }



    @GetMapping("unanswered")
    public String unansweredView(
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model) {
        PageRequest pageRequest = PageRequest.of(page-1, firstAidConfiguration.getPagingPageSize());
        Page<EmergencyCall> emergencyCallsPage = emergencyCallService.findUnanswered(pageRequest);

        model.addAttribute("emergencyCallsPage", emergencyCallsPage);
        ControllerUtils.paging(model,emergencyCallsPage);
        addGlobalAttributes(model);

        return "emergency-call/index";
    }
}
