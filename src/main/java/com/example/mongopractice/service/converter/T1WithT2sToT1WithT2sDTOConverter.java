package com.example.mongopractice.service.converter;

import com.example.mongopractice.service.model.T1WithT2sDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.mongopractice.repository.model.T1WithT2s;

@Component
public class T1WithT2sToT1WithT2sDTOConverter implements Converter< T1WithT2s, T1WithT2sDTO> {
    @Override
    public T1WithT2sDTO convert(@NotNull T1WithT2s from) {
        return new T1WithT2sDTO(from.getId(), from.getT2s());
    }
}

