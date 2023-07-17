package com.stackroute.p2plp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stackroute.p2plp.model.User;
import com.stackroute.p2plp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    @Autowired
    private UserRepository userRepository;

    // private PasswordEncoder passwordEncoder;

    // public User saveUser(User user) {
    // user.setPassword(passwordEncoder.encode(user.getPassword()));
    // return userRepository.save(user);
    // }

    // public boolean validateUser(String email, String password) {
    // return userRepository.existsById(email) &&
    // userRepository.findById(email).get().getPassword().equals(password);
    // }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
