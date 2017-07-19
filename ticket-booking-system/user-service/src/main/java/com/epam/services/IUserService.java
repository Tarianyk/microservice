package com.epam.services;

import com.epam.domain.User;

import java.util.List;

public interface IUserService {
    User getUserById(long userId);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name, int pageSize, int pageNum);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(long userId);

    boolean isUserExist(User user);
}
