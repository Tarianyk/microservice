package com.epam.controllers;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TicketCommandController.class, secure = false)
public class TicketCommandControllerTest {

}