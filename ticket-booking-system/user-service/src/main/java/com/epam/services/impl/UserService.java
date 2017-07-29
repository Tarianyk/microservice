package com.epam.services.impl;

import com.epam.domain.User;
import com.epam.dto.UserDto;
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
    public User createUser(UserDto userDto) {
        return userRepository.save(extractUser(userDto));
    }

    private User extractUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    @Override
    public User updateUser(UserDto userDto) {
        User user = extractUser(userDto);

        return userRepository.updateUser(user.getName(), user.getEmail(), user.getId());
    }

    @Override
    public boolean deleteUser(long userId) {
        userRepository.delete(userId);

        return userRepository.findOne(userId) == null;
    }

    @Override
    public boolean isUserExist(UserDto userDto) {
        return Optional.ofNullable(userRepository.findOne(userDto.getId())).isPresent();
    }


}
