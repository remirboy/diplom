package com.example.diplom.dto;

import com.example.diplom.models.MainPageObject;
import com.example.diplom.models.WebElement;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PageObjectDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private ArrayList<WebElement> elements;

    public static PageObjectDTO from(PageObjectDTO pageObjectDTO) {
        return PageObjectDTO.builder()
                .name(pageObjectDTO.getName())
                .elements(pageObjectDTO.getElements())
                .build();
    }

}
