package com.example.diplom.services;

import com.example.diplom.dto.AttributetsDTO;
import com.example.diplom.dto.ModelDTO;
import com.example.diplom.models.Attribute;
import com.example.diplom.models.Model;
import com.example.diplom.utils.JavaFileWriter;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.stereotype.Component;
import lombok.*;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class ModelService {

    public void generateModel(ModelDTO form) {

        ArrayList<Attribute> attributes = new ArrayList<Attribute>();

      /*  attributes.add(new Attribute("String","var1"));
        attributes.add(new Attribute("Int","var2"));
        attributes.add(new Attribute("Boolean","var3"));*/

      /*  for(AttributetsDTO attributeDTO: attributetsDTO){
            Attribute attribute = Attribute.builder()
                    .type(attributeDTO.getType())
                    .name(attributeDTO.getName())
                    .build();
            attributes.add(attribute);
        }
*/
        Model model = Model.builder()
                .name(form.getName())
                .attributes(form.getAttributes())
                .build();

//        System.out.println(model.toString());

        generateCode(model);

    }

//    private static ArrayList<AttributetsDTO> fromAttributetsDTO(ArrayList<Attribute> attributes){
//        ArrayList<AttributetsDTO> attributetsDTO = new ArrayList<>();
//        for(Attribute attribute: attributes) {
//            attributetsDTO.add(
//                    AttributetsDTO.builder()
//                            .name(attribute.getName())
//                            .type(attribute.getType())
//                            .build());
//        }
//        return attributetsDTO;
//    }

    private void generateCode(Model model){
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
        javaClass.setPackage("output.models").setName(model.getName());

        System.out.println(model.getAttributes().toString());
        for (Attribute attribute:model.getAttributes()){
            javaClass.addProperty(attribute.getType(),attribute.getName());
        }

        System.out.println(javaClass);

        try {
            JavaFileWriter writer = new JavaFileWriter();
            writer.writeJavaCodeToJavaFile(javaClass.toString(),model.getName(),"models");
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
}
