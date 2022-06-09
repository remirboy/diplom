package com.example.diplom.services;

import com.example.diplom.dto.HelperDTO;
import com.example.diplom.models.Attribute;
import com.example.diplom.models.Helper;
import com.example.diplom.models.PageObject;
import com.example.diplom.models.WebElement;
import com.example.diplom.utils.JavaFileWriter;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class HelperService {

    private static String BASE_HELPER = "BaseHelper";


    public void generateHelperClass(HelperDTO helperDTO){

        ArrayList<String> steps = new ArrayList<String>();

        /*steps.add("step1");
        steps.add("step2");
        steps.add("step3");
*/

        Helper helper = Helper.builder()
                .name(helperDTO.getName())
                .steps(helperDTO.getSteps())
                .build();

        generateHelperCode(helper);
    }


    public void generateBaseHelperClass(){
        generateBaseHelperCode();
    }

    private void generateHelperCode(Helper helper){
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);

        javaClass.setPackage("output.helpers");
        javaClass.setName(helper.getName());
        javaClass.setSuperType(BASE_HELPER);



        javaClass.addField().setPrivate()
                .setType("ApplicationManager")
                .setName("app");

        javaClass.addMethod()
                .setConstructor(true)
                .setPublic()
                .setBody("super(app);\n"+"this.app = app;");

        for (String step:helper.getSteps()){

            javaClass.addMethod()
                    .setPublic()
                    .setReturnTypeVoid()
                    .setName(step);
        }

        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(), helper.getName(), "helpers");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    private void generateBaseHelperCode(){
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);

        javaClass.setPackage("output.helpers");
        javaClass.setName("BaseHelper");

        javaClass.addImport("org.openqa.*");

        javaClass.addProperty("WebDriver","webDriver");
        javaClass.addProperty("ApplicationManager", "app");

        javaClass.addMethod()
                .setConstructor(true)
                .setBody("this.app = app;\n"+
                         "this.webDriver = app.getDriver();"
                        )
                .setPublic()
                .addParameter("ApplicatonManager","app");

        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(), BASE_HELPER,"helpers");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
