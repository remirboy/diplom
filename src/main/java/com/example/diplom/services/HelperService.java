package com.example.diplom.services;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;

@Component
public class HelperService {

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

        System.out.println(javaClass);
    }
}
