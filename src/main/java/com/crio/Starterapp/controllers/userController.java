package com.crio.Starterapp.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crio.Starterapp.services.userService;
import com.crio.Starterapp.models.User;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private userService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        userList.sort(Comparator.comparingInt(User::getScore).reversed());
        
        // // Include badges in the response
        // userList.forEach(user -> {
        //     Set<String> badges = getBadges(user.getUserId());
        //     user.setBadges(badges);
        // });

        return ResponseEntity.ok(userList);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateScore(@PathVariable String userId, @RequestParam int score) {
        User updatedUser = userService.updateScore(userId, score);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deregisterUser(@PathVariable String userId) {
        userService.deregisterUser(userId);
        return ResponseEntity.noContent().build();
    }
}

