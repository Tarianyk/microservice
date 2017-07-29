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
import java.util.Objects;

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
        return userRepository.save(conversionService.convert(userDto, User.class));
    }

    @Override
    public User updateUser(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        userRepository.updateUser(user.getName(), user.getEmail(), user.getId());

        return userRepository.findOne(user.getId());
    }

    @Override
    public boolean deleteUser(long userId) {
        userRepository.delete(userId);

        return userRepository.findOne(userId) == null;
    }

    @Override
    public boolean isUserExist(UserDto userDto) {
        return Objects.nonNull(userRepository.findOne(userDto.getId()));
    }

}
