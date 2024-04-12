package com.example.verbindung;
import com.example.verbindung.model.User;
import com.example.verbindung.repository.UserRepository;
import com.example.verbindung.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldRegisterNewUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");
        user.setEmail("test@example.com");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        //UserData registeredUser = userService.registerNewUser(new UserData());

        verify(userRepository, times(1)).save(any(User.class));
        //assert(registeredUser.getPassword().equals("encodedPassword"));
        // Weitere Assertions nach Bedarf...
    }
}