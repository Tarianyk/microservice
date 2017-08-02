package com.epam.services;

public interface IRemoteCheckEntity {
    boolean userExists(long id);

    boolean eventExists(long id);
}
