package com.techogise.user_module.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {


    private MockMvc mockMvc;
    private ObjectMapper objectMapper;


//    Keeping this name format for future reference
//    @Test
//    void givenValidInput_whenRegisterUserApiCalled_thenReturnSuccessRes() {
//    }

    @Test
    void shouldReturnSuccessResponse_WhenRegisterUserCalled() throws Exception {
//       Arrange
        UserController userController = new UserController();
//        Act

        mockMvc.perform(post("/api/v1/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString("someString")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.someField", equalTo("someValue")));


//        Assert
    }
}
