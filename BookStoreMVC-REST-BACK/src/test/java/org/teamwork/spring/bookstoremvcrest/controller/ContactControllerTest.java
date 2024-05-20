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
//import org.teamwork.spring.bookstoremvcrest.model.dto.ContactDTO;
//import org.teamwork.spring.bookstoremvcrest.model.dto.RefContactTypeDTO;
//import org.teamwork.spring.bookstoremvcrest.service.impl.ContactServiceImpl;
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
//public class ContactControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private ContactServiceImpl contactService;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private final ContactDTO contactDTO = new ContactDTO(new RefContactTypeDTO("a"), "a", "b", "+37379435954", "+37378124354", "nothing");
//
//    @Test
//    @DisplayName("get contact by id")
//    public void testGetContactById() throws Exception {
//        when(contactService.findByKey(1)).thenReturn(contactDTO);
//
//        mockMvc.perform(get("/contacts/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(contactDTO)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("get all contacts")
//    public void testGetAllContacts() throws Exception {
//        List<ContactDTO> contactsList = new ArrayList<>(List.of(contactDTO));
//        when(contactService.findAll()).thenReturn(contactsList);
//
//        mockMvc.perform(get("/contacts"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(contactsList)))
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("create contact")
//    public void testCreateContact() throws Exception {
//        when(contactService.save(contactDTO)).thenReturn(contactDTO);
//
//        mockMvc.perform(post("/contacts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(contactDTO)))
//                .andExpect(status().isCreated())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("update contact")
//    public void testUpdateContact() throws Exception {
//        when(contactService.update(1, contactDTO)).thenReturn(contactDTO);
//
//        mockMvc.perform(patch("/contacts/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(contactDTO)))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("delete contact")
//    public void testDeleteContact() throws Exception {
//        doNothing().when(contactService).delete(1);
//
//        mockMvc.perform(delete("/contacts/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent())
//                .andDo(print());
//    }
//
//    @Test
//    @DisplayName("get invalid contact id")
//    public void testInvalidContactId() throws Exception {
//        int invalidId = 45;
//
//        when(contactService.findByKey(invalidId)).thenReturn(null);
//
//        mockMvc.perform(get("/contacts/" + invalidId))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @DisplayName("save a contact with an invalid id")
//    public void testSaveAnAlreadyExistentId() throws Exception {
//        when(contactService.save(contactDTO)).thenReturn(null);
//
//        mockMvc.perform(post("/contacts"))
//                .andExpect(status().isBadRequest());
//    }
//}
