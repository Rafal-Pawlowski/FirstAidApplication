package com.xxx.firstaidapplication.common.controller;

import com.xxx.firstaidapplication.FirstAidConfiguration;
import com.xxx.firstaidapplication.category.service.CategoryService;
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
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchViewController extends FirstAidCommonViewController {

    private final EmergencyCallService emergencyCallService;

    private final FirstAidConfiguration firstAidConfiguration;


    @GetMapping
    public String searchView(
            @RequestParam(name = "query", required = false) String query,
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model) {

        PageRequest pageRequest = PageRequest.of(page-1, firstAidConfiguration.getPagingPageSize());

        if(query!=null) {
            Page<EmergencyCall> emergencyCallsPage = emergencyCallService.findByQuery(query, pageRequest);

            model.addAttribute("emergencyCallsPage", emergencyCallsPage);
            model.addAttribute("query", query);

            ControllerUtils.paging(model, emergencyCallsPage);
        }
        addGlobalAttributes(model);

        return "search/index";
    }
}
