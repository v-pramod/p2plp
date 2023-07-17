// package com.stackroute.p2plp.configuration;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Component;

// import com.stackroute.p2plp.model.User;
// import com.stackroute.p2plp.repository.UserRepository;

// @Component
// public class UserInfoUserDetailsService implements UserDetailsService {

// @Autowired
// private UserRepository userRepository;

// @Override
// public UserDetails loadUserByUsername(String firstName) throws
// UsernameNotFoundException {

// Optional<User> user = userRepository.findByFirstName(firstName);

// return user.map(UserInfoUserDetails::new)
// .orElseThrow(() -> new UsernameNotFoundException("User not found" +
// firstName));
// }

// }
