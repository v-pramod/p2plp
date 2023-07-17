// package com.stackroute.p2plp;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.stackroute.p2plp.dao.JwtAuthenticationResponse;
// import com.stackroute.p2plp.model.Role;
// import com.stackroute.p2plp.model.User;
// import com.stackroute.p2plp.repository.UserRepository;
// import com.stackroute.p2plp.service.AuthenticationService;
// import com.stackroute.p2plp.service.JwtService;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// import java.util.Optional;

// public class TestAuthenticationService {

// @Mock
// private UserRepository userRepository;
// @Mock
// private JwtService jwtService;
// @Mock
// private PasswordEncoder passwordEncoder;
// @Mock
// private AuthenticationManager authenticationManager;

// @InjectMocks
// private AuthenticationService authenticationService;

// @BeforeEach
// void setUp() {
// MockitoAnnotations.openMocks(this);
// }

// @Test
// void testSignup() {
// // given
// User newUser = new User();
// newUser.setFirstName("John");
// newUser.setLastName("Doe");
// newUser.setEmail("john.doe@example.com");
// newUser.setPassword("password123");
// newUser.setRole(Role.LENDER);

// User savedUser = User.builder()
// .firstName(newUser.getFirstName())
// .lastName(newUser.getLastName())
// .email(newUser.getEmail())
// .password("encodedPassword")
// .role(newUser.getRole())
// .build();

// when(userRepository.save(any(User.class))).thenReturn(savedUser);
// when(jwtService.generateToken(savedUser)).thenReturn("token");

// // when
// JwtAuthenticationResponse token = authenticationService.signup(newUser);

// // then
// verify(userRepository).save(newUser);
// verify(jwtService).generateToken(savedUser);
// assertEquals("token", token);
// }

// @Test
// void testSignin() {
// // given
// User newUser = new User();
// newUser.setEmail("john.doe@example.com");
// newUser.setPassword("password123");

// User user = User.builder()
// .email(newUser.getEmail())
// .password("encodedPassword")
// .build();

// when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
// .thenReturn(null);
// when(userRepository.findByEmail(newUser.getEmail())).thenReturn(Optional.of(user));
// when(jwtService.generateToken(user)).thenReturn("token");

// // when
// JwtAuthenticationResponse token = authenticationService.signin(newUser);

// // then
// verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
// verify(userRepository).findByEmail(newUser.getEmail());
// verify(jwtService).generateToken(user);
// assertEquals("token", token);
// }
// }
