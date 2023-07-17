package com.stackroute.p2plp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.p2plp.model.User;
import com.stackroute.p2plp.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private ResponseEntity<?> responseEntity;

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            responseEntity = ResponseEntity.ok().body("User saved successfully");
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        try {
            userService.getUserByEmail(email);
            responseEntity = ResponseEntity.ok().body("User fetched successfully");
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
            userService.getAllUsers();
            responseEntity = ResponseEntity.ok().body("Users fetched successfully");
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String email) {
        try {
            userService.updateUser(user);
            responseEntity = ResponseEntity.ok().body("User updated successfully");
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        try {
            userService.deleteUser(email);
            responseEntity = ResponseEntity.ok().body("User deleted successfully");
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }
}
