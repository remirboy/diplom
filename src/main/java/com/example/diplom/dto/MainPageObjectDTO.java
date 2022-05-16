package com.example.diplom.dto;

import com.example.diplom.models.Attribute;
import com.example.diplom.models.MainPageObject;
import com.example.diplom.models.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MainPageObjectDTO {

    private String wait;

    public static MainPageObjectDTO from(MainPageObject mainPageObject) {
        return MainPageObjectDTO.builder()
                .wait(mainPageObject.getWait())
                .build();
    }

}
