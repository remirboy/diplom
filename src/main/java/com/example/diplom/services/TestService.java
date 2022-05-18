package com.example.diplom.services;

import com.example.diplom.dto.TestSuiteDTO;
import com.example.diplom.models.PageObject;
import com.example.diplom.models.TestCase;
import com.example.diplom.models.TestSuite;
import com.example.diplom.models.WebElement;
import com.example.diplom.utils.JavaFileWriter;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class TestService {

    private static String BASE_TEST = "BaseTest";

    public void generateTestSuiteClass(TestSuiteDTO testSuiteDTO){

//        ArrayList<TestCase> testCases = new ArrayList<TestCase>();
//
//        ArrayList<String> checks = new ArrayList<String>();
//
//        checks.add("hello");
//        checks.add("hi");
//        checks.add("goodbye");
//        checks.add("bye");
//
//        ArrayList<String> checks2 = new ArrayList<String>();
//
//        checks2.add("a");
//        checks2.add("b");
//        checks2.add("c");
//        checks2.add("d");
//
//        ArrayList<String> checks3 = new ArrayList<String>();
//
//        checks3.add("q");
//        checks3.add("w");
//        checks3.add("e");
//        checks3.add("r");
//
//        testCases.add(new TestCase("createPost",checks));
//        testCases.add(new TestCase("deletePost",checks2));
//        testCases.add(new TestCase("updatePost",checks3));


        TestSuite testSuite = TestSuite.builder()
                .name(testSuiteDTO.getName())
                .tests(testSuiteDTO.getTests())
                .build();


        generateTestCode(testSuite);
    }

    private void generateTestCode(TestSuite testSuite) {
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);

        javaClass.setPackage("output.tests");
        javaClass.setName(testSuite.getName());
        javaClass.setSuperType(BASE_TEST);



        ArrayList<ArrayList<String>> checks = new ArrayList<ArrayList<String>>();



        for (TestCase testCase:testSuite.getTests()) {
            checks.add((testCase.getChecks()));
        }

        System.out.println("Все проверки"+checks);


        for (int k=0;k<testSuite.getTests().size();k++){


            javaClass.addMethod()
                    .setPublic()
                    .setReturnTypeVoid()
                    .setName(testSuite.getTests().get(k).getName())
                    .setBody(getChecksToConcreteTestCase(testSuite.getTests().get(k)));

//            System.out.println(getChecksToConcreteTestCase(checks));
        }



        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(), testSuite.getName(), "tests");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getChecksToConcreteTestCase(TestCase testCase){
        ArrayList<String> checksToTestCase = new ArrayList<String>();
        ArrayList<String> checkToTestCase = new ArrayList<String>();

        for (int i=0;i<testCase.getChecks().size();i++){
                checksToTestCase.add("Assert.assertEquals("+testCase.getChecks().get(i)+",actualResult);");
        }

        StringBuilder sb = new StringBuilder();

        for (String s:checksToTestCase) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }




    public void generateBaseTestClass(){
        generateBaseTestCode();
    }

    private void generateBaseTestCode() {
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
        javaClass.setName(BASE_TEST).setPackage("output.tests");

        javaClass.addImport("org.junit.Before");

        javaClass.addField()
                .setType("ApplicationManager")
                .setName("app")
                .setProtected();

        javaClass.addMethod()
                .setName("setUp")
                .setBody("app = new ApplicationManager();")
                .setPublic()
                .addAnnotation("Before");

        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(), BASE_TEST, "tests");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
