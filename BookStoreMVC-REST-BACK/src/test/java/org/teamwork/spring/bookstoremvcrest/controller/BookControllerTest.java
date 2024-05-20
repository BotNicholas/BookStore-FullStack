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
//import org.teamwork.spring.bookstoremvcrest.model.dto.BookCategoryDTO;
//import org.teamwork.spring.bookstoremvcrest.model.dto.BookDTO;
//import org.teamwork.spring.bookstoremvcrest.service.impl.BookServiceImpl;
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
//public class BookControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private BookServiceImpl bookService;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    BookDTO bookDTO = new BookDTO(new AuthorDTO("a", "ab", "ab", LocalDate.of(2000, 04, 23), "M", "+37379344245", "sport analyst"), new BookCategoryDTO("sf"), "123-4-22-234567-1", LocalDate.of(2000, 04, 23), LocalDate.of(2005, 04, 28), "Sample Book Title", 19.99, "Sample comments about the book.");
//
//    @Test
//    @DisplayName("get book by id")
//    public void testGetBookById() throws Exception {
//        when(bookService.findByKey(1)).thenReturn(bookDTO);
//
//        mockMvc.perform(get("/books/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(bookDTO)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("get all books")
//    public void testGetAllBooks() throws Exception {
//        List<BookDTO> booksList = new ArrayList<>(List.of(bookDTO));
//        when(bookService.findAll()).thenReturn(booksList);
//
//        mockMvc.perform(get("/books"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(booksList)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("create book")
//    public void testCreateBook() throws Exception {
//        when(bookService.save(bookDTO)).thenReturn(bookDTO);
//
//        mockMvc.perform(post("/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookDTO)))
//                .andExpect(status().isCreated())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("update book")
//    public void testUpdateBook() throws Exception {
//        when(bookService.update(1, bookDTO)).thenReturn(bookDTO);
//
//        mockMvc.perform(patch("/books/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookDTO)))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("delete book")
//    public void testDeleteBook() throws Exception {
//        doNothing().when(bookService).delete(1);
//
//        mockMvc.perform(delete("/books/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("get invalid book id")
//    public void testInvalidBookId() throws Exception {
//        int invalidId = 45;
//
//        when(bookService.findByKey(invalidId)).thenReturn(null);
//
//        mockMvc.perform(get("/books/" + invalidId))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @DisplayName("save a book with an already existing id")
//    public void testSaveAnAlreadyExistentId() throws Exception {
//        when(bookService.save(bookDTO)).thenReturn(null);
//
//        mockMvc.perform(post("/books"))
//                .andExpect(status().isBadRequest());
//    }
//
//}
