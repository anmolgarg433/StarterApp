package com.crio.Starterapp.service;

import com.crio.Starterapp.services.*;
import com.crio.Starterapp.models.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringBootTest
public class UserServicesTest {

    @Autowired
    private userService userService;

    @Test
    public void testRegisterUser() {
        User user = new User("1", "testUser", 50, null);
        User registeredUser = userService.registerUser(user);
        assertNotNull(registeredUser);
        assertEquals("1", registeredUser.getUserId());
        assertEquals("testUser", registeredUser.getUsername());
        assertEquals(50, registeredUser.getScore());
        assertNotNull(registeredUser.getBadges());
    }

    @Test
    public void testUpdateScore() {
        User user = new User("1", "testUser", 50, null);
        userService.registerUser(user);
        User updatedUser = userService.updateScore("1", 70);
        assertEquals(70, updatedUser.getScore());
        System.out.println(user);
        // Check if badges are updated correctly
        assertTrue(updatedUser.getBadges().contains("Code Master"));
    }

    @Test
    public void testGetUserById() {
        User user = new User("1", "testUser", 50, null);
        userService.registerUser(user);
        User retrievedUser = userService.getUserById("1");
        assertNotNull(retrievedUser);
        assertEquals("1", retrievedUser.getUserId());
        assertEquals("testUser", retrievedUser.getUsername());
        assertEquals(50, retrievedUser.getScore());
        assertNotNull(retrievedUser.getBadges());
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User("1", "testUser1", 50, null);
        User user2 = new User("2", "testUser2", 70, null);
        userService.registerUser(user1);
        userService.registerUser(user2);
        List<User> userList = userService.getAllUsers();
        assertEquals(2, userList.size());
        // Check if users are sorted by score
        assertTrue(userList.get(0).getScore() >= userList.get(1).getScore());
    }

    @Test
    public void testDeregisterUser() {
        User user = new User("1", "testUser", 50, null);
        userService.registerUser(user);
        userService.deregisterUser("1");
        assertNull(userService.getUserById("1"));
    }
}
