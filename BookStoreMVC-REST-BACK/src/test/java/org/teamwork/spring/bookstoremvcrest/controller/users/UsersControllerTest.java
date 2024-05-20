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
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
//import org.teamwork.spring.bookstoremvcrest.security.controllers.UsersController;
//import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreRegistrationUserDTO;
//import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreUserDTO;
//import org.teamwork.spring.bookstoremvcrest.security.services.BookStoreUserServiceImpl;
//import org.teamwork.spring.bookstoremvcrest.utils.NotFoundError;
//import org.teamwork.spring.bookstoremvcrest.utils.UsedIdError;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//import static org.teamwork.spring.bookstoremvcrest.controller.users.UsersControllerTestConstants.URL;
//
//@AutoConfigureMockMvc(addFilters = false)
//@WebMvcTest(controllers = UsersController.class)
//public class UsersControllerTest {
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
//    private final CostumerDTO costumerDTO2 = new CostumerDTO(2, "2000000000000", "test costumer2", "test address2", "+37320000000", "example2@gmail.com");
//    private final BookStoreUserDTO bookStoreUserDTO1 = new BookStoreUserDTO("user1", "Password_123", "ROLE_USER", costumerDTO1);
//    private final BookStoreUserDTO bookStoreUserDTO2 = new BookStoreUserDTO("user2", "Password_123", "ROLE_USER", costumerDTO2);
//
//    private final BookStoreRegistrationUserDTO registrationUserDTO = new BookStoreRegistrationUserDTO("username", "Password_123", costumerDTO1);
//
//
//    @Test
//    @DisplayName("find all users test...")
//    public void findAllUsers() throws Exception {
//        List users = List.of(bookStoreUserDTO1, bookStoreUserDTO2);
//        Mockito.when(service.findAll()).thenReturn(users);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
//                .characterEncoding(StandardCharsets.UTF_8));
//
//        actions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(users)))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("find 1'st user test...")
//    public void findFirstUser() throws Exception {
//        Mockito.when(service.findByKey(1)).thenReturn(bookStoreUserDTO1);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/1")
//                .characterEncoding(StandardCharsets.UTF_8));
//
//        actions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(bookStoreUserDTO1)))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("find non-existing user test...")
//    public void findNonExistingUser() throws Exception {
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/777")
//                .characterEncoding(StandardCharsets.UTF_8));
//
//        actions.andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new NotFoundError("Such user was not found!"))))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("save user without id test...")
//    public void saveUserWithoutId() throws Exception {
//        Mockito.when(service.save(bookStoreUserDTO1)).thenReturn(bookStoreUserDTO1);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(bookStoreUserDTO1)));
//
//        actions.andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string("Success!"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("save user with id test...")
//    public void saveUserWithId() throws Exception {
//        bookStoreUserDTO1.setId(1);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(bookStoreUserDTO1)));
//
//        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is unexpected for User"))))
//                .andDo(MockMvcResultHandlers.print());
//
//        bookStoreUserDTO1.setId(null);
//    }
//
//    @Test
//    @DisplayName("register new user without id...")
//    public void registerUserWithoutId() throws Exception {
//        Mockito.when(service.register(registrationUserDTO)).thenReturn(bookStoreUserDTO1);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL + "/register")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(registrationUserDTO)));
//
//        actions.andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string("Success!"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("register new user with id...")
//    public void registerUserWithId() throws Exception {
//        registrationUserDTO.setId(1);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL + "/register")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(registrationUserDTO)));
//
//        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is unexpected here!"))))
//                .andDo(MockMvcResultHandlers.print());
//
//        registrationUserDTO.setId(null);
//    }
//
//    @Test
//    @DisplayName("update 1'st user test...")
//    public void updateFirstUser() throws Exception {
//        Mockito.when(service.update(1, bookStoreUserDTO1)).thenReturn(bookStoreUserDTO1);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.patch(URL + "/1")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(bookStoreUserDTO1)));
//
//        actions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Success!"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("delete 1'st user test...")
//    public void deleteFirstUser() throws Exception {
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.delete(URL + "/1")
//                .characterEncoding(StandardCharsets.UTF_8));
//
//        actions.andExpect(MockMvcResultMatchers.status().isNoContent())
//                .andExpect(MockMvcResultMatchers.content().string("Delete successful!"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//}
