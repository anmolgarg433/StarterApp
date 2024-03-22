Contest Leaderboard Management Service

Introduction
This project is a contest leaderboard management service designed to handle CRUD operations for a single contest with a single leaderboard. It provides endpoints for registering users, updating scores, retrieving user details, and deregistering users from the contest.

Requirements
- Java 8 or higher
- Spring Boot
- Gradle

Installation
1. Clone the repository:
   git clone https://github.com/anmolgarg433/StarterApp
2. Navigate to the project directory:
   cd starterapp
3. Build the project using Maven:
   mvn clean install
4. Run the application:
   mvn spring-boot:run

Endpoints
- GET /users - Retrieve a list of all registered users
- GET /users/{userId} - Retrieve the details of a specific user
- POST /users - Register a new user to the contest
- PUT /users/{userId} - Update the score of a specific user
- DELETE /users/{userId} - Deregister a specific user from the contest

Usage
- To register a new user:
  curl -X POST -H "Content-Type: application/json" -d '{"userId":"1","username":"john_doe","score":50}' http://localhost:8080/users
- To update a user's score:
  curl -X PUT -H "Content-Type: application/json" -d '{"score":75}' http://localhost:8080/users/1
- To retrieve all users:
  curl http://localhost:8080/users
- To retrieve a specific user:
  curl http://localhost:8080/users/1
- To deregister a user:
  curl -X DELETE http://localhost:8080/users/1

Testing
- Unit tests for services are provided using JUnit and Mockito. You can run them using:
  mvn test

Future Improvements
- Add authentication and authorization for secure access to endpoints.
- Implement pagination for large user lists.
- Add support for multiple contests and leaderboards.

Contributing
Contributions are welcome! Please fork the repository and create a pull request with your proposed changes.

License
This project is licensed under the MIT License - see the LICENSE file for details.
