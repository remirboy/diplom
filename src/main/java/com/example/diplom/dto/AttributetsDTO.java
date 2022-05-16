package com.example.diplom.dto;

import com.example.diplom.models.Attribute;
import com.example.diplom.models.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AttributetsDTO {

    private String type;
    private String name;

    public static AttributetsDTO from(Attribute attribute) {
        return AttributetsDTO.builder()
                .name(attribute.getName())
                .type(attribute.getType())
                .build();
    }

}
