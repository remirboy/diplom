package com.example.diplom.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Attribute {
    private String type;
    private String name;

}
