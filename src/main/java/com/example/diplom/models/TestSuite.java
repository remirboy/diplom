package com.example.diplom.models;

import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TestSuite {
    private String name;
    private ArrayList<TestCase> tests;
}
