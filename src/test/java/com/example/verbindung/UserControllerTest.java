package com.example.verbindung;
import com.example.verbindung.controller.UserController;
import com.example.verbindung.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext context) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void shouldRegisterUser() throws Exception {
        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testUser\",\"password\":\"password\",\"email\":\"test@example.com\"}"))
                .andExpect(status().isCreated());
        // Überprüfe die Interaktion mit userService
    }

    @Test
    void shouldGetUserByUsername() throws Exception {
        mockMvc.perform(get("/api/users/testUser")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}