package com.example.diplom.controllers;

import com.example.diplom.dto.MainPageObjectDTO;
import com.example.diplom.dto.ModelDTO;
import com.example.diplom.dto.PageObjectDTO;
import com.example.diplom.models.WebElement;
import com.example.diplom.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @Autowired
    public PageService pageService;


    @GetMapping("/pageObject")
    public String getPageCreationPage() {
            return "page_object";
    }

    @GetMapping("/pageObject/pageGeneration")
    public String getPageGenerationPage(Model model) {
        PageObjectDTO pageObjectDTO = new PageObjectDTO();
//        MainPageObjectDTO mainPageObjectDTO = new MainPageObjectDTO();
//        model.addAttribute("MainPageObjectDTO", MainPageObjectDTO);
        model.addAttribute("pageObjectDTO", pageObjectDTO);

        return "page_generation";
    }

    @PostMapping("/pageObject/pageGeneration/create")
    public String createPageGenerationPage(@ModelAttribute("model_creation") PageObjectDTO pageObjectDTO) {
        pageService.generatePageObject(pageObjectDTO);
        return "main";
    }


    @GetMapping("/pageObject/mainPageGeneration")
    public String getMainPageGenerationPage(Model model) {
        MainPageObjectDTO mainPageObjectDTO = new MainPageObjectDTO();
        model.addAttribute("mainPageObject", mainPageObjectDTO);
        return "page_main_class_generation";
    }

    @PostMapping("/pageObject/mainPageGeneration/create")
    public String createMainPageGenerationPage(@ModelAttribute("page_main_class_generation") MainPageObjectDTO mainPageObjectDTO) {
        pageService.generateMainPageObject(mainPageObjectDTO);
        return "main";
    }

}



