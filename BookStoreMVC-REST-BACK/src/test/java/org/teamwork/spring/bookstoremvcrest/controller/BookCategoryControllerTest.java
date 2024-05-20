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
//import org.teamwork.spring.bookstoremvcrest.model.dto.BookCategoryDTO;
//import org.teamwork.spring.bookstoremvcrest.service.impl.BookCategoryServiceImpl;
//
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
//public class BookCategoryControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private BookCategoryServiceImpl categoryService;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private final BookCategoryDTO bookCategoryDTO = new BookCategoryDTO("lots of plot-twists");
//
//    @Test
//    @DisplayName("get book category by id")
//    public void testGetBookCategoryById() throws Exception {
//        when(categoryService.findByKey(1)).thenReturn(bookCategoryDTO);
//
//        mockMvc.perform(get("/categories/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(bookCategoryDTO)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("get all books categories")
//    public void testGetBookCategories() throws Exception {
//        List<BookCategoryDTO> categoryList = new ArrayList<>(List.of(bookCategoryDTO));
//        when(categoryService.findAll()).thenReturn(categoryList);
//
//        mockMvc.perform(get("/categories"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(categoryList)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("create book category")
//    public void testSaveCategory() throws Exception {
//        when(categoryService.save(bookCategoryDTO)).thenReturn(new BookCategoryDTO());
//
//        mockMvc.perform(post("/categories")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookCategoryDTO)))
//                .andExpect(status().isCreated())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("update book category")
//    public void testUpdateCategory() throws Exception {
//        when(categoryService.update(1, bookCategoryDTO)).thenReturn(new BookCategoryDTO());
//
//        mockMvc.perform(patch("/categories/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookCategoryDTO)))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("delete book category")
//    public void testDeleteCategory() throws Exception {
//        doNothing().when(categoryService).delete(1);
//
//        mockMvc.perform(delete("/categories/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("get invalid book category id")
//    public void testInvalidBookCategoryId() throws Exception {
//        int invalidId = 43;
//        when(categoryService.findByKey(invalidId)).thenReturn(null);
//
//        mockMvc.perform(get("/categories/" + invalidId))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @DisplayName("save book category with invalid id")
//    public void testSaveAnAlreadyExistentId() throws Exception {
//        when(categoryService.save(bookCategoryDTO)).thenReturn(null);
//
//        mockMvc.perform(post("/categories"))
//                .andExpect(status().isBadRequest());
//    }
//}
