//package org.teamwork.spring.bookstoremvcrest.controller.users;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
//import org.teamwork.spring.bookstoremvcrest.security.controllers.UsersController;
//import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreUserDTO;
//import org.teamwork.spring.bookstoremvcrest.security.services.BookStoreUserServiceImpl;
//
//import java.nio.charset.StandardCharsets;
//
//import static org.teamwork.spring.bookstoremvcrest.controller.AuthenticationTestsConstants.userDetails;
//import static org.teamwork.spring.bookstoremvcrest.controller.users.UsersControllerTestConstants.URL;
//
//@AutoConfigureMockMvc
//@WebMvcTest(controllers = UsersController.class)
//public class AuthorizedUsersControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private BookStoreUserServiceImpl service;
//    @MockBean
//    private PasswordEncoder encoder;
//
//    private final CostumerDTO costumerDTO1 = new CostumerDTO(1, "1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com");
//    private final BookStoreUserDTO userDTO = new BookStoreUserDTO("aaa", "Password_123", "aaa", costumerDTO1);
//
//    @Test
//    @DisplayName("get authorized user's info test...")
//    public void getUserInfo() throws Exception {
//        Mockito.when(service.findByUsername("aaa")).thenReturn(userDTO);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/me")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null))));
//
//        actions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(userDTO)))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("update authorized user's info test...")
//    public void updateUserInfo() throws Exception {
//        Mockito.when(service.update("aaa", userDTO)).thenReturn(userDTO);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.patch(URL + "/me")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(userDTO))
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null)))
//                .with(SecurityMockMvcRequestPostProcessors.csrf()));
//
//        actions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Success!"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//}
