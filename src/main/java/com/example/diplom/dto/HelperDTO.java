package com.example.diplom.dto;

import com.example.diplom.models.Attribute;
import com.example.diplom.models.Helper;
import com.example.diplom.models.Model;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class HelperDTO {

    private ArrayList<String> steps;
    private String name;

    public static HelperDTO from(Helper helper) {
        return HelperDTO.builder()
                .name(helper.getName())
                .steps(helper.getSteps())
                .build();
    }
}
