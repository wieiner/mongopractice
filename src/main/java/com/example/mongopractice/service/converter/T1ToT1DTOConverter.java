package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.T1;
import com.example.mongopractice.repository.model.T2;
import com.example.mongopractice.service.model.T1DTO;
import com.example.mongopractice.service.model.T2DTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class T1ToT1DTOConverter implements Converter<T1, T1DTO> {


    @Override
    public T1DTO convert(@NotNull T1 from) {

        return new T1DTO(from.getId(), from.getForeignId(), from.getArrayIds());
    }
}

