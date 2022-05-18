package com.example.diplom.dto;

import com.example.diplom.models.TestCase;
import com.example.diplom.models.TestSuite;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TestCaseDTO {
    private String name;
    private ArrayList<String> checks;

    public static TestCaseDTO from(TestCase testCase) {
        return TestCaseDTO.builder()
                .name(testCase.getName())
                .checks(testCase.getChecks())
                .build();
    }
}
