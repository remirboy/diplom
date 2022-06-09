package com.example.diplom.services;

import com.example.diplom.dto.MainPageObjectDTO;
import com.example.diplom.dto.PageObjectDTO;
import com.example.diplom.models.*;
import com.example.diplom.utils.JavaFileWriter;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Component
public class PageService {

    private final static String MainPageName = "PageObject";

    public void generatePageObject(PageObjectDTO form){

        /*ArrayList<WebElement> webElements = new ArrayList<WebElement>();

        webElements.add(new WebElement("object1","some_id","id","button"));
        webElements.add(new WebElement("object2","some_class","className","text"));
        webElements.add(new WebElement("object3","bodydivdiv","xPath","input"));

*/
        PageObject pageObject = PageObject.builder()
                .name(form.getName())
                .elements(form.getElements())
                .build();

        generatePageObjectCode(pageObject);
    }

    private void generatePageObjectCode(PageObject pageObject){

        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
        javaClass.setPackage("output.pages").setName(pageObject.getName());
        javaClass.setSuperType(MainPageName);
        javaClass.addImport("org.openqa.selenium.*");

        for (WebElement webElement:pageObject.getElements()){
            javaClass.addProperty("By",webElement.getName());

            javaClass.addMethod().setName("initialize"+webElement.getName())
                    .setBody("this."+webElement.getName()+"=By."+webElement.getLocatorType()+"(\""+addLocatorPrefix(webElement)+webElement.getLocator()+"\");");

            switch (webElement.getWebElementType()) {
                case "button":
                    javaClass.addMethod().setName("click"+webElement.getLocator()+"button")
                            .setBody("webDriver.findElement("+webElement.getName()+").click();\n"+
                                     "return this;")
                            .setReturnType(pageObject.getName())
                            .setPublic();
                    break;
                case "text":
                    javaClass.addMethod().setName("find"+webElement.getLocator())
                            .setBody("webDriver.findElement("+webElement.getName()+");\n"+
                                     "return this;")
                            .setReturnType(pageObject.getName())
                            .setPublic();
                    break;
                case "input":
                    javaClass.addMethod().setName("typeDataIn"+webElement.getLocator())
                            .setBody("webDriver.findElement("+webElement.getName()+").clear().sendKeys(inputData);\n"+
                                    "return this;")
                            .setReturnType(pageObject.getName())
                            .setParameters("String inputData")
                            .setPublic();
                    break;
                default:
                    javaClass.addMethod().setName("find"+webElement.getLocator());
                    break;
            }

        }

        System.out.println(javaClass);

        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(),pageObject.getName(),"pages");
        }
        catch (IOException e){
            e.printStackTrace();
        }
//        javaClass.addMethod()
//                .setConstructor(true)
//                .setPublic()
//                .setBody("this.id = id;")
//                .addParameter(Integer.class, "id");
    }

    private String addLocatorPrefix(WebElement webElement){
        String finalLocator;
        switch (webElement.getLocatorType()) {
            case "id":
                finalLocator = "#";
                break;
            case "className":
                finalLocator = ".";
                break;
            case "cssSelector":
                finalLocator="cssSelector";
                break;
            case "tagName":
                finalLocator="tagName";
                break;
            case "linkText":
                finalLocator="linkText";
                break;
            case "partialLinkText":
                finalLocator="partialLinkText";
                break;
            case "name":
                finalLocator="name";
                break;
            case "xpath":
                finalLocator="xpath";
                break;
            default:
                finalLocator="className";
                break;
        }
        System.out.println(finalLocator);
        return finalLocator;
    }


    public void generateMainPageObject(MainPageObjectDTO form){
        MainPageObject pageObject = MainPageObject.builder()
                .wait(form.getWait())
                .build();
        generateMainPageObjectCode(pageObject.getWait());
    }

    private void generateMainPageObjectCode(String wait){
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
        javaClass.setName(MainPageName).setPackage("output.pages");
        javaClass.addImport("org.openqa.selenium.support.ui.WebDriverWait");

        javaClass.addProperty("WebDriver", "webDriver");

        javaClass.addMethod()
                .setConstructor(true)
                .setBody("this.webDriver = webDriver;")
                .setPublic()
                .addParameter("WebDriver","webDriver");

        javaClass.addMethod().setName("waitShowElement")
                .setParameters("By className")
                .setPublic()
                .setBody("WebDriverWait wait = new WebDriverWait(webDriver,"+wait+");\n" +
                        "wait.until(ExpectedConditions.visibilityOfElementLocated(By.className));");

        javaClass.addMethod().setName("isElementPresent")
                .setReturnType("Boolean")
                .setParameters("By by")
                .setPublic()
                .addThrows(NoSuchElementException.class)
                .setBody("webDriver.findElement(by);\n" +
                        "return true;\n"
                        ) ;

        System.out.println(javaClass);

        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(),MainPageName,"pages");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
