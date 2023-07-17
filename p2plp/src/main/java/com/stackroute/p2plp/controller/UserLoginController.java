package com.stackroute.p2plp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.p2plp.model.User;
import com.stackroute.p2plp.service.AuthenticationService;
import com.stackroute.p2plp.service.UserLoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class UserLoginController {

    @Autowired
    // private UserLoginService userLoginService;
    private final AuthenticationService authenticationService;
    private ResponseEntity<?> responseEntity;

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            authenticationService.signup(user);
            responseEntity = ResponseEntity.ok().body("User saved successfully");
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
        // return ResponseEntity.ok(authenticationService.signin(user));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> validateUser(@RequestBody User user) {

        // if (authenticationService.signin(user) != null) {
        // responseEntity = ResponseEntity.ok().body("User validated");
        // } else {
        // responseEntity = ResponseEntity.badRequest().body("User not validated");
        // }
        // return responseEntity;
        return ResponseEntity.ok(authenticationService.signin(user));
    }
}
