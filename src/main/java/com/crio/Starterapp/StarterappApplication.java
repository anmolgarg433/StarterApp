package com.crio.Starterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crio.Starterapp.models.User;

/**
 * The main class of the StarterApp application.
 * This class is responsible for starting the Spring Boot application.
 */
@SpringBootApplication
public class StarterappApplication {

    /**
     * The main method of the application, which starts the Spring Boot application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Run the Spring Boot application.
		User user = new User();
        System.out.println(user.getBadges());
        SpringApplication.run(StarterappApplication.class, args);
    }
}