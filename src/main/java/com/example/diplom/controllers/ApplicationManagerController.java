package com.example.diplom.controllers;

import com.example.diplom.dto.ApplicationManagerDTO;
import com.example.diplom.dto.ModelDTO;
import com.example.diplom.services.ApplicationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationManagerController {

    @Autowired
    private ApplicationManagerService applicationManagerService;

    @PostMapping("/applicationManager/create")
    public String generateApplicationManagerClass(ApplicationManagerDTO managerDTO) {
        applicationManagerService.generateApplicationManagerClass(managerDTO);
        return "main";
    }

    @GetMapping("/applicationManager")
    public String getGenerateApplicationManagerClass(Model model) {
        ApplicationManagerDTO managerDTO = new ApplicationManagerDTO();
        model.addAttribute("ApplicationManagerDTO", managerDTO);
        return "app_manager_creation";
    }
}

