package org.teamwork.spring.bookstoremvcrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.teamwork.spring.bookstoremvcrest.model.dto.RefContactTypeDTO;
import org.teamwork.spring.bookstoremvcrest.service.impl.RefContactTypeServiceImpl;
import org.teamwork.spring.bookstoremvcrest.utils.NotFoundError;
import org.teamwork.spring.bookstoremvcrest.utils.UsedIdError;

import java.nio.charset.StandardCharsets;
import java.util.List;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = RefContactTypeController.class)
public class RefContactTypeControllerTest {
    private static final String URL = "/ref-contact-types";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RefContactTypeServiceImpl service;

    private final RefContactTypeDTO refContactTypeDTO1 = new RefContactTypeDTO("TEST1");
    private final RefContactTypeDTO refContactTypeDTO2 = new RefContactTypeDTO("TEST2");

    @Test
    @DisplayName("find all ref contact types test...")
    public void findAllRefContactTypes() throws Exception {
        List contactTypes = List.of(refContactTypeDTO1, refContactTypeDTO2);
        Mockito.when(service.findAll()).thenReturn(contactTypes);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(contactTypes)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find 1'st ref contact type test...")
    public void findFirstRefContactType() throws Exception {
        Mockito.when(service.findByKey(1)).thenReturn(refContactTypeDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(refContactTypeDTO1)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find non-existing ref contact type test...")
    public void findNonExistingRefContactType() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/777")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new NotFoundError("Such object was not found!"))))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new ref contact type without id test...")
    public void saveRefContactTypeWithoutId() throws Exception {
        Mockito.when(service.save(refContactTypeDTO1)).thenReturn(refContactTypeDTO1);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(refContactTypeDTO1)));

        resultActions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Save successful!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new ref contact type with id test...")
    public void saveRefContactTypeWithId() throws Exception {
        refContactTypeDTO1.setCode(1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(refContactTypeDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is unexpected here!!!"))))
                .andDo(MockMvcResultHandlers.print());

        refContactTypeDTO1.setCode(null);
    }

    @Test
    @DisplayName("update 1'st ref contact type test...")
    public void updateFirstRefContactType() throws Exception {
        Mockito.when(service.update(1, refContactTypeDTO1)).thenReturn(refContactTypeDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.patch(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(refContactTypeDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Update successful!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("delete 1'st ref contact type test...")
    public void deleteFirstRefContactType() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.delete(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string("Delete successful!"))
                .andDo(MockMvcResultHandlers.print());
    }
}
