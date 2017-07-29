package com.epam.services.impl;

import com.epam.domain.User;
import com.epam.repository.UserRepository;
import com.epam.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConversionService conversionService;

    @Override
    public User getUserById(long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userRepository.findUsersByNameContaining(name, new PageRequest(pageSize, pageNum));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user.getName(), user.getEmail(), user.getId());
    }

    @Override
    public boolean deleteUser(long userId) {
        userRepository.delete(userId);

        return userRepository.findOne(userId) == null;
    }

    @Override
    public boolean isUserExist(User user) {
        return Optional.ofNullable(userRepository.findOne(user.getId())).isPresent();
    }


}
