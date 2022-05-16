package com.example.diplom.controllers;

import com.example.diplom.dto.AttributetsDTO;
import org.springframework.ui.Model;
import com.example.diplom.dto.ModelDTO;
import com.example.diplom.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Controller
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping("/model/modelGeneration")
    public String getPageGenerationPage(Model model) {
        ModelDTO modelDTO = new ModelDTO();
        ArrayList<AttributetsDTO> attributesDTO = new ArrayList<>();
        attributesDTO.add(new AttributetsDTO("type1","name1"));
        attributesDTO.add(new AttributetsDTO("type1","name1"));
        attributesDTO.add(new AttributetsDTO("type1","name1"));
;//        ArrayList<AttributetsDTO> attributetsDTO = new ArrayList<>();
        model.addAttribute("modelDTO", modelDTO);
        model.addAttribute("attributesDTO",attributesDTO);
//        model.addAttribute("attributetsDTO", attributetsDTO);
//        HashMap<String, String> languages = new LinkedHashMap<String, String>();
//        languages.put("Int","Int");
//        languages.put("Float","Float");
//        languages.put("String","String");
//        languages.put("Boolean","Boolean");
//        model.addAttribute("languages", languages);
        return "model_creation";
    }

    @PostMapping("/model/modelGeneration/create")
    public String generatePage(@ModelAttribute("model_creation") ModelDTO modelDTO) {
//        attributetsDTO.add(new AttributetsDTO("String","var1"));
//        attributetsDTO.add(new AttributetsDTO("Int","var2"));
//        attributetsDTO.add(new AttributetsDTO("Boolean","var3"));
        modelService.generateModel(modelDTO);
        return "main";
    }

}
