package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T2;
import com.example.mongopractice.service.model.T1DTO;
import com.example.mongopractice.service.model.T2DTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class T2DTOToT2Converter implements Converter<T2DTO, T2> {
    @Override
    public T2 convert(@NotNull T2DTO from) {
        return new T2(from.getId(), from.getIds());
    }
}

