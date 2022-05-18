package com.example.diplom.controllers;

import com.example.diplom.dto.MainPageObjectDTO;
import com.example.diplom.dto.PageObjectDTO;
import com.example.diplom.dto.TestCaseDTO;
import com.example.diplom.dto.TestSuiteDTO;
import com.example.diplom.models.TestCase;
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


    @GetMapping("/test/mainTest")
    public String getMainPageGenerationPage() {
        return "base_test_class_generation";
    }

    @PostMapping("/test/mainTest/create")
    public String createBaseTest() {
        testService.generateBaseTestClass();
        return "main";
    }

    @GetMapping("/test/testSuite")
    public String getTestsGenerationPage(Model model) {
        TestSuiteDTO testSuiteDTO = new TestSuiteDTO();
//        TestCaseDTO testCaseDTO = new TestCaseDTO();
        model.addAttribute("testSuiteDTO",testSuiteDTO);

        return "tests_generation";
    }

    @PostMapping("/test/testSuite/create")
    public String createTestSuite(@ModelAttribute("tests_generation") TestSuiteDTO testSuiteDTO) {
        testService.generateTestSuiteClass(testSuiteDTO);
        return "main";
    }
}
