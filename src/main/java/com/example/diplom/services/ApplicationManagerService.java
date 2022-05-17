package com.example.diplom.services;

import com.example.diplom.dto.ApplicationManagerDTO;
import com.example.diplom.utils.JavaFileWriter;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationManagerService {

    private static String APPLICATION_MANAGER = "ApplicationManager";

    public void generateApplicationManagerClass(ApplicationManagerDTO managerDTO){
        generateCode(managerDTO);
    }

    private void generateCode(ApplicationManagerDTO managerDTO){

        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
        javaClass.setName("ApplicationManager");
        javaClass.addImport("org.openqa.*");

        javaClass.addField()
                .setName("baseURL")
                .setType(String.class)
                .setStringInitializer(managerDTO.getBaseURL())
                .setProtected();

        javaClass.addProperty("BaseHelper", "baseHelper");
        javaClass.addProperty("WebDriver", "webDriver");
        javaClass.addProperty("Map<String, Object>", "vars");
        javaClass.addProperty("JavascriptExecutor", "js");


        javaClass.addMethod().setConstructor(true)
                .setPublic()
                .setBody("System.setProperty(\"webdriver."+chooseBrowser(managerDTO)+".driver\", \""+managerDTO.getWebDriverPath()+"\");\n"+
                        "driver = new "+chooseBrowser(managerDTO)+"Driver();\n"+
                        "js = (JavascriptExecutor) driver;\n"+
                        "vars = new HashMap<String, Object>();\n"+
                        "baseHelper = new BaseHelper(this, baseUrl);\n"+
                        "webDriver.get(baseUrl);\n"
                        );



        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(),APPLICATION_MANAGER,"root");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    private String chooseBrowser(ApplicationManagerDTO managerDTO){
        if (managerDTO.getWebDriver().equalsIgnoreCase("chrome"))
            return "ChromeDriver";
        else
            return "FirefoxDriver";
    }
}
