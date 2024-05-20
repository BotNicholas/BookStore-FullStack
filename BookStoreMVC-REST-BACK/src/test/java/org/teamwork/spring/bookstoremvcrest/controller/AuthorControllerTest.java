//package org.teamwork.spring.bookstoremvcrest.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
////import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.teamwork.spring.bookstoremvcrest.model.dto.AuthorDTO;
//import org.teamwork.spring.bookstoremvcrest.service.impl.AuthorServiceImpl;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@AutoConfigureMockMvc(addFilters = false)
//@SpringBootTest
////@WithMockUser(username = "admin", roles = "ADMIN")
//public class AuthorControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private AuthorServiceImpl authorService;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private final AuthorDTO authorDTO1 = new AuthorDTO("a", "ab", "ab", LocalDate.of(2000, 04, 23), "M", "+37379344245", "sport analyst");
//    private final AuthorDTO authorDTO2 = new AuthorDTO("c", "d", "cd", LocalDate.of(1999, 07, 22), "M", "+37378227243", "loves camping");
//
//    @Test
//    @DisplayName("get author by id")
//    public void testGetAuthorById() throws Exception {
//        when(authorService.findByKey(1)).thenReturn(authorDTO1);
//
//        mockMvc.perform(get("/authors/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(authorDTO1)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("get all authors")
//    public void testGetAuthors() throws Exception {
//        List<AuthorDTO> listAuthors = new ArrayList<>(List.of(authorDTO1, authorDTO2));
//        when(authorService.findAll()).thenReturn(listAuthors);
//
//        mockMvc.perform(get("/authors"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(listAuthors)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("create author")
//    public void testCreateThenReturnAuthor() throws Exception {
//        when(authorService.save(authorDTO1)).thenReturn(authorDTO1);
//
//        mockMvc.perform(post("/authors")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(authorDTO1)))
//                .andExpect(status().isCreated())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("update author")
//    public void testUpdateAuthor() throws Exception {
//        when(authorService.update(1, authorDTO1)).thenReturn(authorDTO1);
//
//        mockMvc.perform(patch("/authors/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(authorDTO1)))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("delete author")
//    public void testDeleteAuthor() throws Exception {
//        doNothing().when(authorService).delete(1);
//
//        mockMvc.perform(delete("/authors/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent())
//                .andDo(print());
//
//    }
//
//    @Test
//    @DisplayName("get invalid author id")
//    public void testInvalidAuthorId() throws Exception {
//        int invalidId = 43;
//
//        when(authorService.findByKey(invalidId)).thenReturn(null);
//
//        mockMvc.perform(get("/authors/" + invalidId))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @DisplayName("save an author with an invalid id")
//    public void testSaveAnAlreadyExistentId() throws Exception {
//        when(authorService.save(authorDTO1)).thenReturn(null);
//
//        mockMvc.perform(post("/authors"))
//                .andExpect(status().isBadRequest());
//    }
//}
//
