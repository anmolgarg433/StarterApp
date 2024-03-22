package com.crio.Starterapp.models;

import java.util.*;
// import jakarta.persistence.Entity; 
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import java.util.Objects;

// @Entity
public class User {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String username;
    int score;
    private List<String> badges;

    public User() {
        System.out.println("A new User object has been created.");
        badges = new ArrayList<>();
    }

    public User(String userId, String username, int score, List<String> badges) {
        this.userId = userId;
        this.username = username;
        this.score = score;
        this.badges = badges;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getBadges() {
        return badges;
    }

    public void setBadges(List<String> badges) {
        this.badges = badges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return score == user.score &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(username, user.username) &&
                Objects.equals(badges, user.badges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, score, badges);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", score=" + score +
                ", badges=" + badges +
                '}';
    }
}

