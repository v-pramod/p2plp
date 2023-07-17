package com.stackroute.p2plp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stackroute.p2plp.dao.JwtAuthenticationResponse;
import com.stackroute.p2plp.model.Role;
import com.stackroute.p2plp.model.User;
import com.stackroute.p2plp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse signup(User newUser) {
        var user = User.builder().firstName(newUser.getFirstName()).lastName(newUser.getLastName())
                .email(newUser.getEmail()).password(passwordEncoder.encode(newUser.getPassword()))
                .role(newUser.getRole()).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public JwtAuthenticationResponse signin(User newUser) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(newUser.getEmail(), newUser.getPassword()));
        var user = userRepository.findByEmail(newUser.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();

    }
}
