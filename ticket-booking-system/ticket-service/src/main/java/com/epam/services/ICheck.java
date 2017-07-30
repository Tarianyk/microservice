package com.epam.services;

public interface ICheck {
    boolean userExists(long id);

    boolean eventExists(long id);
}
