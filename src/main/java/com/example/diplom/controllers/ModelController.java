package com.example.diplom.controllers;

import com.example.diplom.dto.AttributetsDTO;
import com.example.diplom.dto.HelperDTO;
import com.example.diplom.models.Attribute;
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


    private static ModelDTO models = new ModelDTO();

    static {
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute());
        attributes.add(new Attribute());
        attributes.add(new Attribute());

        models.setAttributes(attributes);

    }
    @PostMapping("/attribute/add")
    public String attributeAdd(Model model) {
        models.getAttributes().add(new Attribute());
        return "redirect:/model/modelGeneration";
    }

    @PostMapping("/attribute/delete")
    public String attributeDelete(Model model) {
        models.getAttributes().remove(models.getAttributes().size() - 1);
        return "redirect:/model/modelGeneration";
    }
    @GetMapping("/model/modelGeneration")
    public String getPageGenerationPage(Model model) {
        ModelDTO modelDTO = new ModelDTO();
        ArrayList<AttributetsDTO> attributesDTO = new ArrayList<>();

        model.addAttribute("modelDTO", modelDTO);
        model.addAttribute("attributesDTO",attributesDTO);
        model.addAttribute("model",models);
        model.addAttribute("attributes",models.getAttributes());
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
