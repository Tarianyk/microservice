package com.epam.controllers;

import com.epam.domain.User;
import com.epam.dto.UserDto;
import com.epam.exceptions.UserExistException;
import com.epam.services.IUserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
//TODO: remake on different types of methods
public class UserController {

    private static final String USER_ALREADY_EXISTS = "User already exists.";
    private static final String USER_DOESNT_EXIST =  "User doesn't exist.";

    @Autowired
    private IUserService userService;

    //TODO: In case nothing was found, empty list is returned.
    @RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") long userId) {
        Optional<User> optUser = Optional.ofNullable(userService.getUserById(userId));

        return optUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByEmail(@PathVariable(value = "email") String email) {
        Optional<User> optUser = Optional.ofNullable(userService.getUserByEmail(email));

        return optUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsersByName(@PathVariable(value = "name") String name,
                                                     @RequestParam("from") int pageSize,
                                                     @RequestParam("to") int pageNum) {
        Optional<List<User>> optUsers = Optional.ofNullable(userService.getUsersByName(name, pageSize, pageNum));

        return optUsers.map(users -> new ResponseEntity<List<User>>(users, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<List<User>>(Lists.newArrayList(), HttpStatus.OK));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDto userDto) {
        if (userService.isUserExist(userDto)) {
            throw new UserExistException(USER_ALREADY_EXISTS, HttpStatus.CONFLICT);
        }
        userService.createUser(userDto);

        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    //TODO: remake query
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserDto userDto) {
        if (!userService.isUserExist(userDto)) {
            throw new UserExistException(USER_DOESNT_EXIST, HttpStatus.CONFLICT);
        }
        User updatedUser = userService.updateUser(userDto);

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return new ResponseEntity<String>("User has been deleted.", HttpStatus.OK);
        }

        return new ResponseEntity<String>("User hasn't been deleted.", HttpStatus.CONFLICT);
    }


}
