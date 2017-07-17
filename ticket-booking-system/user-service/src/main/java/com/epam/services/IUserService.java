package com.epam.services;

import com.epam.domain.User;
import com.epam.dto.UserDto;

import java.util.List;

public interface IUserService {
    User getUserById(long userId);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name, int pageSize, int pageNum);

    User createUser(UserDto userDto);

    User updateUser(User user);

    boolean deleteUser(long userId);
}
