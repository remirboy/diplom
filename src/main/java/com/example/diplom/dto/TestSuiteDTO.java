package com.example.diplom.dto;

import com.example.diplom.models.Helper;
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

public class TestSuiteDTO {
    private String name;
    private ArrayList<TestCase> tests;

    public static TestSuiteDTO from(TestSuite suite) {
        return TestSuiteDTO.builder()
                .name(suite.getName())
                .tests(suite.getTests())
                .build();
    }
}
