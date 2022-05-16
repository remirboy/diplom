package com.example.diplom.dto;

import com.example.diplom.models.ApplicationManagerModel;
import com.example.diplom.models.MainPageObject;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ApplicationManagerDTO{
    private String baseURL;
    private String webDriver;
    private String webDriverPath;

    public static ApplicationManagerDTO from(ApplicationManagerModel managerModel) {
        return ApplicationManagerDTO.builder()
                .baseURL(managerModel.getBaseURL())
                .webDriver(managerModel.getWebDriver())
                .webDriverPath(managerModel.getWebDriverPath())
                .build();
    }

}
