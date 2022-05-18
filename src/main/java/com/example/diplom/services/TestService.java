package com.example.diplom.services;

import com.example.diplom.utils.JavaFileWriter;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TestService {

    private static String BASE_TEST = "BaseTest";

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
