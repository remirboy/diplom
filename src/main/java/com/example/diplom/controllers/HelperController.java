package com.example.diplom.controllers;

import com.example.diplom.dto.ApplicationManagerDTO;

import com.example.diplom.dto.HelperDTO;
import com.example.diplom.dto.ModelDTO;
import com.example.diplom.dto.PageObjectDTO;
import com.example.diplom.models.WebElement;
import com.example.diplom.services.HelperService;
import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
public class HelperController {

    @Autowired
    private HelperService helperService;


    private static HelperDTO helpers = new HelperDTO();

    static {
        ArrayList<String> steps = new ArrayList<>();
        steps.add("");
        steps.add("");
        steps.add("");

        helpers.setSteps(steps);

    }

    @PostMapping("/step/add")
    public String stepAdd(Model model) {
        helpers.getSteps().add(new String());
        return "redirect:/helper/helperGeneration";
    }

    @PostMapping("/step/delete")
    public String stepDelete(Model model) {
        helpers.getSteps().remove(helpers.getSteps().size() - 1);
        return "redirect:/helper/helperGeneration";
    }


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
        model.addAttribute("helpers", helpers);
        model.addAttribute("steps", helpers.getSteps());
        return "helper_generation";
    }

    @PostMapping("/helper/helperGeneration/create")
    public String generateHelperPage(@ModelAttribute("helper_generation") HelperDTO helperDTO) {
        try {
            helperService.generateHelperClass(helperDTO);
            return "main";
        } catch (NullPointerException e){
            return "redirect:/helper/helperGeneration";
        }
    }

}
