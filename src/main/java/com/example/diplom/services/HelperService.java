package com.example.diplom.services;

import com.example.diplom.utils.JavaFileWriter;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HelperService {

    private static String BASE_HELPER = "BaseHelper";

    public void generateBaseHelperClass(){
        generateCode();
    }

    private void generateCode(){
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
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
