package com.example.diplom.controllers;

import com.example.diplom.dto.ApplicationManagerDTO;

import com.example.diplom.dto.HelperDTO;
import com.example.diplom.dto.ModelDTO;
import com.example.diplom.services.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HelperController {

    @Autowired
    private HelperService helperService;

    @GetMapping("/helper")
    public String getHelperGenerationPage() {
        return "helper_object";
    }

    @GetMapping("/helper/baseHelperGeneration")
    public String getBaseHelperPage() {
        return "base_helper_class_generation";
    }

    @PostMapping("/helper/baseHelperGeneration/create")
    public String generateBaseHelperPage() {
        helperService.generateBaseHelperClass();
        return "main";
    }

    @GetMapping("/helper/helperGeneration")
    public String getHelperPage(Model model) {
        HelperDTO helperDTO = new HelperDTO();
        model.addAttribute("helperDTO", helperDTO);
        return "helper_generation";
    }

    @PostMapping("/helper/helperGeneration/create")
    public String generateHelperPage(@ModelAttribute("helper_generation") HelperDTO helperDTO) {
        helperService.generateHelperClass(helperDTO);
        return "main";
    }

}
