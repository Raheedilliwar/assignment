
package com.example.demo;

import org.junit.jupiter.api.*;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = new UserService();
    }

    @Test
    public void testSaveAndGetUser() {
        User saved = userService.saveUser(new User(null, "John"));
        User fetched = userService.getUserById(saved.getId());
        assertEquals("John", fetched.getName());
    }
}
