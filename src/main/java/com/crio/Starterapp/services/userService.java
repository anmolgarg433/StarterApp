package com.crio.Starterapp.services;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crio.Starterapp.models.*;
// import com.crio.Starterapp.controllers.*;

@Service
public class userService {

    private Map<String, User> userMap = new ConcurrentHashMap<>();

    public List<User> getAllUsers() {
        return userMap.values().stream()
                .sorted(Comparator.comparingInt(User::getScore).reversed())
                .collect(Collectors.toList());
    }

    public User getUserById(String userId) {
        return userMap.get(userId);
    }

    public User registerUser(User user) {
        // Basic validation
        if (user.getScore() < 0 || user.getScore() > 100) {
            throw new IllegalArgumentException("Invalid score");
        }

        user.setBadges(new ArrayList<>()); // Initialize badges
        userMap.put(user.getUserId(), user);
        return user;
    }

    public User updateScore(String userId, int score) {
        User user = userMap.get(userId);
        if (user == null) {
            throw new NoSuchElementException("User not found");
        }

        // Basic validation
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Invalid score");
        }

        user.setScore(score);
        awardBadges(user);
        userMap.put(userId, user);
        return user;
    }

    public void deregisterUser(String userId) {
        userMap.remove(userId);
    }

    private void awardBadges(User user) {
        List<String> badges = new ArrayList<>(); // Initialize badges
    
        if (user.getScore() >= 1 && user.getScore() <= 30) {
            badges.add("Code Ninja");
        } else if (user.getScore() >= 31 && user.getScore() <= 60) {
            badges.add("Code Champ");
        } else if (user.getScore() >= 61 && user.getScore() <= 100) {
            badges.add("Code Master");
        }
    
        user.setBadges(badges); // Set the badges directly
    }
    
}