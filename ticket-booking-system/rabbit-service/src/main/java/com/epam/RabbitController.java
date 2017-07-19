package com.epam;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO: remake on different types of methods
public class RabbitController {

    @Autowired
    AmqpTemplate template;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test() {
        System.err.println("``````````````````````````````````````");
        template.convertAndSend("queue1", "LOOOOOL");

        return null;
    }
}
