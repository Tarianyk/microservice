package com.epam.controllers.impl;

import com.epam.controllers.IUserController;
import com.epam.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements IUserController {

    @RequestMapping(value = "/id/{userId}")
    @Override
    public User getUserById(@PathVariable(value = "userId") long userId) {
        User user = new User();
        user.setId(userId);
        user.setEmail("test@email.com");
        System.out.println(user.getEmail());
        return user;
    }

    @RequestMapping(value = "/email/{email}")
    @Override
    public User getUserByEmail(@PathVariable(value = "email") String email) {
        return null;
    }

    @RequestMapping(value = "/name/{name}")
    @Override
    public List<User> getUsersByName(@PathVariable(value = "name") String name) {
        return null;
    }

    @Override
    public User createUser() {
        return null;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @RequestMapping(value = "/delete")
    @Override
    public boolean deleteUser() {
        return true;
    }
}
