package org.teamwork.spring.bookstoremvcrest.controller.order;

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
import org.teamwork.spring.bookstoremvcrest.controller.OrderController;
import org.teamwork.spring.bookstoremvcrest.model.dto.BookDTO;
import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
import org.teamwork.spring.bookstoremvcrest.model.dto.FullOrderDTO;
import org.teamwork.spring.bookstoremvcrest.model.dto.LightOrderItemDTO;
import org.teamwork.spring.bookstoremvcrest.service.impl.OrderServiceImpl;
import org.teamwork.spring.bookstoremvcrest.utils.NotFoundError;
import org.teamwork.spring.bookstoremvcrest.utils.UsedIdError;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import static org.teamwork.spring.bookstoremvcrest.controller.order.OrderControllerTestConstants.URL;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = OrderController.class)
@DisplayName("Order Controller Test")
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderServiceImpl service;

    private final CostumerDTO costumerDTO1 = new CostumerDTO(1, "1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com");
    private final CostumerDTO costumerDTO2 = new CostumerDTO(2, "2000000000000", "test costumer2", "test address2", "+37320000000", "example2@gmail.com");
    private final CostumerDTO costumerDTO3 = new CostumerDTO(3, "3000000000000", "test costumer3", "test address3", "+37330000000", "example3@gmail.com");
    private final LightOrderItemDTO lightOrderItemDTO1 = new LightOrderItemDTO(new BookDTO(), 20.0, "comment 1", 1);
    private final LightOrderItemDTO lightOrderItemDTO2 = new LightOrderItemDTO(new BookDTO(), 20.0, "comment 2", 1);
    private final LightOrderItemDTO lightOrderItemDTO3 = new LightOrderItemDTO(new BookDTO(), 20.0, "comment 3", 1);
    private final FullOrderDTO fullOrderDTO1 = new FullOrderDTO(costumerDTO1, new Date(), 12.0, List.of(lightOrderItemDTO1));
    private final FullOrderDTO fullOrderDTO2 = new FullOrderDTO(costumerDTO2, new Date(), 12.0, List.of(lightOrderItemDTO2));
    private final FullOrderDTO fullOrderDTO3 = new FullOrderDTO(costumerDTO3, new Date(), 12.0, List.of(lightOrderItemDTO3));

    @Test
    @DisplayName("find all orders test...")
    public void findAllOrders() throws Exception {
        List<FullOrderDTO> fullOrderDTOS = List.of(fullOrderDTO1, fullOrderDTO2);
        Mockito.when(service.findAll()).thenReturn(fullOrderDTOS);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(fullOrderDTOS)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find 1'st order test...")
    public void findFirstOrder() throws Exception {
        Mockito.when(service.findByKey(1)).thenReturn(fullOrderDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(fullOrderDTO1)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find non-existing order...")
    public void findNonExistingOrder() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/777")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new NotFoundError("Such object was not found!"))))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new order without id test...")
    public void saveNewOrderWithoutId() throws Exception {
        Mockito.when(service.save(fullOrderDTO1)).thenReturn(fullOrderDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fullOrderDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Success!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new order with id test...")
    public void saveNoeOrderWithId() throws Exception {
        fullOrderDTO1.setId(1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fullOrderDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is not expected here"))))
                .andDo(MockMvcResultHandlers.print());

        fullOrderDTO1.setId(null);
    }

    @Test
    @DisplayName("save new order with specified order items id test...")
    public void saveNewOrderWithOrderItemsIdsTest() throws Exception {
        lightOrderItemDTO1.setId(1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fullOrderDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is unexpected in OrderItems!"))))
                .andDo(MockMvcResultHandlers.print());

        lightOrderItemDTO1.setId(null);
    }

    @Test
    @DisplayName("update 1'st order test...")
    public void updateFirstOrderTest() throws Exception {
        Mockito.when(service.update(1, fullOrderDTO1)).thenReturn(fullOrderDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.patch(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fullOrderDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Success!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("delete 1'st order test...")
    public void deleteFirstOrder() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.delete(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string("Delete successful!"))
                .andDo(MockMvcResultHandlers.print());
    }
}
