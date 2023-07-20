package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.T2;
import com.example.mongopractice.service.model.T1DTO;
import com.example.mongopractice.service.model.T2DTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class T2ToT2DTOConverter implements Converter<T2, T2DTO> {
    @Override
    public T2DTO convert(@NotNull T2 from) {
        return new T2DTO(from.getId(), from.getIds());
    }
}

