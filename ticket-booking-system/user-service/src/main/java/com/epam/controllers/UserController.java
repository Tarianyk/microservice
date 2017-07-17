package com.epam.controllers;

import com.epam.domain.User;
import com.epam.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//TODO: remake on different methods
public class UserController {

    @Autowired
    private IUserService userService;

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
                .orElseGet(() -> new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (userService.isUserExist(user)) {
            return new ResponseEntity<String>("CONFLICT ERROR", HttpStatus.CONFLICT);
        }
        userService.createUser(user);

        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    //TODO: remake query
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        if (!userService.isUserExist(user)) {
            return new ResponseEntity<String>("CONFLICT ERROR", HttpStatus.CONFLICT);
        }
        User updatedUser = userService.updateUser(user);

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}