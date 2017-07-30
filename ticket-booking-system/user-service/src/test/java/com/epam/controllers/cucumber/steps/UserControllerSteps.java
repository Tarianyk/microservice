package com.epam.controllers.cucumber.steps;

import com.epam.config.DataBaseConfigurationTest;
import com.epam.controllers.UserController;
import com.epam.domain.User;
import com.epam.dto.UserDto;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@ContextConfiguration(classes = DataBaseConfigurationTest.class)
@SpringBootTest
public class UserControllerSteps {

    @Autowired
    private UserController userController;

    @Given("^the bank creates one user (.*) with email (.*)$")
    public void createUser(String name, String email) {
        userController.createUser(getUser(name, email));
    }

    private UserDto getUser(String name, String email) {
        UserDto user = new UserDto();
        user.setEmail(email);
        user.setName(name);

        return user;
    }

    @When("^the client wants to change his old email (.*) on (.*)")
    public void theClientUpdatesAccount(String oldEmail, String newEmail) {
        User oldUser = userController.getUserByEmail(oldEmail).getBody();
        oldUser.setEmail(newEmail);
        userController.updateUser(createUserDto(oldUser));
    }

    private UserDto createUserDto(User oldUser) {
        UserDto userDto = new UserDto();
        userDto.setId(oldUser.getId());
        userDto.setName(oldUser.getName());
        userDto.setEmail(oldUser.getEmail());

        return userDto;
    }

    @Then("^the client with email (.*) wants to check his data$")
    public void theClientChecksHisAccount(String email) {
        User user = userController.getUserByEmail(email).getBody();
        System.err.println(user);
        assertNotNull(user);
    }
}
