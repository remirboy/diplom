package com.example.diplom.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class WebElement {

    @NotEmpty
    private String name;
    @NotEmpty
    private String locator;
    @NotEmpty
    private String locatorType;
    @NotEmpty
    private String webElementType;
}
