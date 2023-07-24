package com.example.mongopractice.service.converter;

import com.example.mongopractice.repository.model.User;
import com.example.mongopractice.service.model.UserDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUserConverter implements Converter<UserDTO, User> {
    @Override
    public User convert(@NotNull UserDTO from) {


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

        return new User(from.getId(), from.getName(), from.getSurname(), address);
    }
}

