package com.example.diplom.controllers;

import com.example.diplom.dto.ModelDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Controller
public class MainContoller {

    @GetMapping("/")
    public String getMainPage() {
        return "main";
    }


    @GetMapping("/hello")
    public String hello(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";

    }

}
