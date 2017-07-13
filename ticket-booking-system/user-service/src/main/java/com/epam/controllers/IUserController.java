package com.epam.controllers;

import com.epam.domain.User;

import java.util.List;

public interface IUserController {
    /**
     * Gets user by its id.
     *
     * @param userId User id.
     * @return User.
     */
    User getUserById(long userId);

    /**
     * Gets user by its email. Email is strictly matched.
     *
     * @return User.
     */
    User getUserByEmail(String email);

    /**
     * Get list of users by matching name. Name is matched using 'contains' approach.
     * In case nothing was found, empty list is returned.
     *
     * @return List of users.
     */
    List<User> getUsersByName(String name);

    /**
     * Creates new user. User id should be auto-generated.
     *
     * @return Created User object.
     */
    User createUser();

    /**
     * Updates user using given data.
     *
     * @return Updated User object.
     */
    User updateUser();

    /**
     * Deletes user by its id.
     *
     * @return Flag that shows whether user has been deleted.
     */
    boolean deleteUser();
}
