package com.example.mongopractice.service.model;

import com.example.mongopractice.repository.model.T2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class T1WithT2sDTO {
    private String id;
    private List<T2> t2s;

}
