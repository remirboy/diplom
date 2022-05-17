package com.example.diplom.controllers;

import com.example.diplom.dto.MainPageObjectDTO;
import com.example.diplom.dto.PageObjectDTO;
import com.example.diplom.services.PageService;
import com.example.diplom.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @Autowired
    public TestService testService;


    @GetMapping("/test")
    public String getPageCreationPage() {
        return "test_object";
    }

//    @GetMapping("/test/mainTest")
//    public String getPageGenerationPage(Model model) {
//        PageObjectDTO pageObjectDTO = new PageObjectDTO();
////        MainPageObjectDTO mainPageObjectDTO = new MainPageObjectDTO();
////        model.addAttribute("MainPageObjectDTO", MainPageObjectDTO);
//        model.addAttribute("pageObjectDTO", pageObjectDTO);
//
//        return "page_generation";
//    }
//
//    @PostMapping("/test/mainTest/create")
//    public String createPageGenerationPage(@ModelAttribute("model_creation") PageObjectDTO pageObjectDTO) {
//        pageService.generatePageObject(pageObjectDTO);
//        return "main";
//    }


    @GetMapping("/test/mainTest")
    public String getMainPageGenerationPage() {
        return "base_test_class_generation";
    }

    @PostMapping("/test/mainTest/create")
    public String createBaseTest() {
        testService.generateBaseTestClass();
        return "main";
    }
}
