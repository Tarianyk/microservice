package com.epam.services.impl;

import com.epam.domain.User;
import com.epam.dto.UserDto;
import com.epam.services.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    //    @Autowired
    @Mock
    private IUserService userService;

    @Test
    public void test_ml_always_return_true() {
        User user = new User();
        user.setEmail("test@email");
        UserDto userDto = new UserDto();
        userDto.setEmail("test@email");

        Mockito.when(userService.createUser(Mockito.anyObject())).thenReturn(user);
        User user1 = userService.createUser(Mockito.anyObject());
        assertEquals(user.getEmail(), user1.getEmail());
        assertThat(userService, instanceOf(IUserService.class));
    }

    @Test
    public void test_ml_always_return_true123() {
        User user = new User();
        user.setEmail("test@email");
        UserDto userDto = new UserDto();
        userDto.setEmail("test@email");

        Mockito.when(userService.getUserByEmail(Mockito.anyString())).thenReturn(user);
        User user1 = userService.getUserByEmail(Mockito.anyString());
        assertEquals(user.getEmail(), user1.getEmail());
        assertThat(userService, instanceOf(IUserService.class));
    }
}