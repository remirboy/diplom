package com.example.diplom.controllers;

import com.example.diplom.dto.TestSuiteDTO;
import com.example.diplom.models.TestCase;
import com.example.diplom.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    public TestService testService;
    private static TestSuiteDTO testSuites = new TestSuiteDTO();

    static {
        ArrayList<String> checks = new ArrayList<>();
        checks.add("");
        checks.add("");
        checks.add("");
        ArrayList<TestCase> tests = new ArrayList<>();
        tests.add(new TestCase("",checks));
        tests.add(new TestCase("",checks));
        tests.add(new TestCase("",checks));


        testSuites.setTests(tests);

    }

    @GetMapping("/test")
    public String getPageCreationPage() {
        return "test_object";
    }

    @PostMapping("/tests/add")
    public String checkAdd(Model model) {
        ArrayList<String> checks = new ArrayList<>();
        checks.add("");
        checks.add("");
        checks.add("");
        testSuites.getTests().add(new TestCase(null,checks));
        return "redirect:/test/testSuite";
    }

    @PostMapping("/tests/delete")
    public String checkDelete(Model model) {
        testSuites.getTests().remove(testSuites.getTests().size()-1);
        return "redirect:/test/testSuite";
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
        model.addAttribute("testSuites",testSuites);
        model.addAttribute("tests",testSuites.getTests());

        return "tests_generation";
    }

    @PostMapping("/test/testSuite/create")
    public String createTestSuite(@ModelAttribute("tests_generation") TestSuiteDTO testSuiteDTO) {
        testService.generateTestSuiteClass(testSuiteDTO);
        return "main";
    }
}
