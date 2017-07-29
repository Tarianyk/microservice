package com.epam.converter;

import com.epam.domain.User;
import com.epam.dto.UserDto;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
