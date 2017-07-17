package com.epam.converters;

import com.epam.domain.User;
import com.epam.dto.UserDto;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
