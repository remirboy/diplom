package com.example.diplom.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ApplicationManagerModel {
    private String baseURL;
    private String webDriver;
    private String webDriverPath;
}
