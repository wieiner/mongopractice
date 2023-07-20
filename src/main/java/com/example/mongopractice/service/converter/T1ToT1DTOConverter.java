package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.service.model.T1DTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class T1ToT1DTOConverter implements Converter<T1, T1DTO> {
    @Override
    public T1DTO convert(@NotNull T1 from) {
        return new T1DTO(from.getId(), from.getArray_ids());
    }
}

