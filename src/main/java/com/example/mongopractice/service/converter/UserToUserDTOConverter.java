package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.T1WithT2s;
import com.example.mongopractice.repository.model.User;
import com.example.mongopractice.service.model.T1WithT2sDTO;
import com.example.mongopractice.service.model.UserDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(@NotNull User from) {
        // Прямое преобразование для Address
        User.Address fromAddress = from.getAddress();
        User.Address address = null;
        User.Address.HomeAddress homeAddress = null;

        if (fromAddress != null) {

            if (fromAddress.getHomeAddress() != null) {

                homeAddress = new User.Address.HomeAddress(
                        fromAddress.getHomeAddress().getCity(),
                        fromAddress.getHomeAddress().getStreet(),
                        fromAddress.getHomeAddress().getBuilding()
                );
            }

            address = new User.Address(
                    fromAddress.getPhone(),
                    fromAddress.getEmail(),
                    homeAddress);

        }


        return new UserDTO(from.getId(), from.getName(), from.getSurname(), address);
    }
}

