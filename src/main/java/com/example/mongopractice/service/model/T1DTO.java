package com.example.mongopractice.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class T1DTO {
    private String id;

    private String[] array_ids;
}
