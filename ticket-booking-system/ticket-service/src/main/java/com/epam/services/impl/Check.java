package com.epam.services.impl;

import com.epam.services.IRemoteCheckEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class Check implements IRemoteCheckEntity {

    private static final String URL_GET_USER_BY_ID = "http://localhost:8079/api/user/id/{id}";
    private static final String URL_GET_EVENT_BY_ID = "http://localhost:8079/api/event/id/{id}";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean userExists(long id) {
        return restTemplate.getForEntity(URL_GET_USER_BY_ID, String.class, id).getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean eventExists(long id) {
        return restTemplate.getForEntity(URL_GET_EVENT_BY_ID, String.class, id).getStatusCode() == HttpStatus.OK;
    }

}
