package com.example.mongopractice.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class T2DTO {
    private String id;
    @NotNull
    private String ids;
}
