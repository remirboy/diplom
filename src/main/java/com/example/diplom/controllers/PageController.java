package com.example.diplom.controllers;

import com.example.diplom.dto.MainPageObjectDTO;
import com.example.diplom.dto.PageObjectDTO;
import com.example.diplom.models.WebElement;
import com.example.diplom.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class PageController {

    @Autowired
    public PageService pageService;

    private static PageObjectDTO pageObject = new PageObjectDTO();

    static {
        ArrayList<WebElement> webElements = new ArrayList<>();
        webElements.add(new WebElement());
        webElements.add(new WebElement());
        webElements.add(new WebElement());
        pageObject.setElements(webElements);

    }

    @GetMapping("/pageObject")
    public String getPageCreationPage() {
        return "page_object";
    }

    @PostMapping("/element/add")
    public String elementAdd(Model model) {
        pageObject.getElements().add(new WebElement());
        return "redirect:/pageObject/pageGeneration";
    }

    @PostMapping("/element/delete")
    public String elementDelete(Model model) {
        pageObject.getElements().remove(pageObject.getElements().size() - 1);
        return "redirect:/pageObject/pageGeneration";
    }

    @GetMapping("/pageObject/pageGeneration")
    public String getPageGenerationPage(Model model) {
        PageObjectDTO pageObjectDTO = new PageObjectDTO();
//        MainPageObjectDTO mainPageObjectDTO = new MainPageObjectDTO();
//        model.addAttribute("MainPageObjectDTO", MainPageObjectDTO);
        model.addAttribute("pageObject", pageObject);
        model.addAttribute("elements", pageObject.getElements());
        model.addAttribute("pageObjectDTO", pageObjectDTO);

        return "page_generation";
    }

    @PostMapping("/pageObject/pageGeneration/create")
    public String createPageGenerationPage(@ModelAttribute("model_creation") @Valid PageObjectDTO pageObjectDTO, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
            pageService.generatePageObject(pageObjectDTO);
        } model.addAttribute("noErrors", false);
        return "redirect:/pageObject/pageGeneration";

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



