package com.example.family.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passprodect {
    private Integer id;

    private Integer userid;

    private String username;

    private String question;

    private String answer;
}