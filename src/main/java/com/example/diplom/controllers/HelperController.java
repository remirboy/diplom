package com.example.diplom.controllers;

import com.example.diplom.dto.ApplicationManagerDTO;

import com.example.diplom.services.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Controller
public class HelperController {

    @Autowired
    private HelperService helperService;

    @GetMapping("/helper")
    public String getHelperGenerationPage() {
        return "helper_object";
    }

    @GetMapping("/helper/baseHelperGeneration")
    public String getBaseHelperPage(Model model) {
        ApplicationManagerDTO managerDTO = new ApplicationManagerDTO();
        model.addAttribute("ApplicationManagerDTO", managerDTO);
        return "base_helper_class_generation";
    }

    @PostMapping("/helper/baseHelperGeneration/create")
    public String generateBaseHelperPage() {
        helperService.generateBaseHelperClass();
        return "main";
    }

//    @PostMapping("/pageObject/baseHelperGeneration/create")
//    public String createMainPageGenerationPage(@ModelAttribute("page_main_class_generation") MainPageObjectDTO mainPageObjectDTO) {
//        pageService.generateMainPageObject(mainPageObjectDTO);
//        return "main";
//    }
}
