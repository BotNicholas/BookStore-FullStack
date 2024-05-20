package org.teamwork.spring.bookstoremvcrest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;
import java.nio.file.Paths;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = HomeController.class)
@DisplayName("Home Controller Test")
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String WELCOME_PAGE_PATH = "src/main/resources/templates/welcome.html";

    @Test
    @DisplayName("Welcome page test")
    public void welcomePageTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/"));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/html;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string(Files.readString(Paths.get(WELCOME_PAGE_PATH))))
                .andDo(MockMvcResultHandlers.print());
    }
}
