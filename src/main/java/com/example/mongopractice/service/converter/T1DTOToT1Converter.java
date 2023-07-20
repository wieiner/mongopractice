package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.service.model.T1DTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class T1DTOToT1Converter implements Converter<T1DTO, T1> {
    @Override
    public T1 convert(@NotNull T1DTO from) {
        return new T1(from.getId(), from.getArray_ids());
    }
}

