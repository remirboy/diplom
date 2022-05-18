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
public class TestCase {
    private String name;
    private ArrayList<String> checks;
}
