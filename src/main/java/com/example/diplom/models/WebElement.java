package com.example.diplom.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class WebElement {
    private String name;
    private String locator;
    private String locatorType;
    private String webElementType;
}
