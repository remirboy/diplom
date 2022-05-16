package com.example.diplom.dto;

import com.example.diplom.models.Attribute;
import com.example.diplom.models.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ModelDTO {
    private String name;
    private ArrayList<Attribute> attributes;

//    public static ArrayList<AttributetsDTO> fromAttributetsDTO(ArrayList<Attribute> attributes){
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

    public static ModelDTO from(Model model,ArrayList<Attribute> attributes) {
        return ModelDTO.builder()
                .name(model.getName())
                .build();
    }
}
