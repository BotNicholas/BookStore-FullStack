package org.teamwork.spring.bookstoremvcrest.controller.costumer;

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
import org.teamwork.spring.bookstoremvcrest.controller.CostumerController;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
import org.teamwork.spring.bookstoremvcrest.security.model.BookStoreUser;
import org.teamwork.spring.bookstoremvcrest.service.impl.CostumerServiceImpl;
import org.teamwork.spring.bookstoremvcrest.utils.NotFoundError;
import org.teamwork.spring.bookstoremvcrest.utils.UsedIdError;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.teamwork.spring.bookstoremvcrest.controller.costumer.CostumerControllerTestConstants.URL;

@DisplayName("Unauthorized Costumer Controller Test")
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(CostumerController.class)
public class CostumerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CostumerServiceImpl costumerService;

    private final CostumerDTO costumerDTO1 = new CostumerDTO("1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com", List.of(1, 2, 3));
    private final CostumerDTO costumerDTO2 = new CostumerDTO("2000000000000", "test costumer2", "test address2", "+37320000000", "example2@gmail.com", List.of(4, 5, 6));
    private final CostumerDTO costumerDTO3 = new CostumerDTO("3000000000000", "test costumer3", "test address3", "+37330000000", "example3@gmail.com", List.of(7, 8, 9));


    Costumer costumer = new Costumer("1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com");
    BookStoreUser user = new BookStoreUser("test", "test", "ROLE_USER", costumer);

    @Test
    @DisplayName("find all costumers test")
    public void findAllCostumersTest() throws Exception {
        List<CostumerDTO> costumerDTOS = List.of(costumerDTO1, costumerDTO2);
        when(costumerService.findAll()).thenReturn(costumerDTOS);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(URL));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(costumerDTOS)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find 1'st costumer test")
    public void findCostumerByIdTest() throws Exception {
        Mockito.when(costumerService.findByKey(1)).thenReturn(costumerDTO1);

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/1"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(costumerDTO1)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find non-existent costumer test")
    public void findNonExistentCostumer() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/777"));

        actions.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new NotFoundError("Such object was not found!"))))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new costumer without id test")
    public void saveCostumer() throws Exception {
        Mockito.when(costumerService.save(costumerDTO3)).thenReturn(costumerDTO3);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(objectMapper.writeValueAsString(costumerDTO3)));

        result.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Save success!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new costumer with id test")
    public void saveCostumerWithId() throws Exception {
        costumerDTO3.setId(1);
        Mockito.when(costumerService.save(costumerDTO3)).thenReturn(costumerDTO3);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(objectMapper.writeValueAsString(costumerDTO3)));

        resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is unexpected here!!!"))))
                .andDo(MockMvcResultHandlers.print());

        costumerDTO3.setId(null);
    }

    @Test
    @DisplayName("update 1'st costumer test")
    public void updateCostumer() throws Exception {
        Mockito.when(costumerService.update(1, costumerDTO1)).thenReturn(costumerDTO1);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.patch(URL + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(objectMapper.writeValueAsString(costumerDTO1)));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Update successful!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("delete 1'st costumer test")
    public void deleteCostumer() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.delete(URL + "/1"));

        resultActions.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string("Delete successful!"))
                .andDo(MockMvcResultHandlers.print());
    }
}
