package org.teamwork.spring.bookstoremvcrest.controller.orderitem;

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
import org.teamwork.spring.bookstoremvcrest.controller.OrderItemController;
import org.teamwork.spring.bookstoremvcrest.model.dto.*;
import org.teamwork.spring.bookstoremvcrest.service.impl.OrderItemServiceImpl;
import org.teamwork.spring.bookstoremvcrest.utils.NotFoundError;
import org.teamwork.spring.bookstoremvcrest.utils.UsedIdError;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.teamwork.spring.bookstoremvcrest.controller.orderitem.OrderItemControllerTestConstants.URL;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = OrderItemController.class)
public class OrderItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderItemServiceImpl service;

    private final CostumerDTO costumerDTO1 = new CostumerDTO(1, "1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com");
    private final FullOrderDTO orderDTO1 = new FullOrderDTO(costumerDTO1, new Date(), 10.0, List.of(new LightOrderItemDTO()));
    private final AuthorDTO authorDTO = new AuthorDTO("a", "ab", "ab", LocalDate.of(2000, 04, 23), "M", "+37379344245", "sport analyst");
    private final BookCategoryDTO bookCategoryDTO = new BookCategoryDTO("lots of plot-twists");
    private final BookDTO bookDTO = new BookDTO(authorDTO, bookCategoryDTO, "123-4-22-234567-1", LocalDate.of(2000, 04, 23), LocalDate.of(2005, 04, 28), "Sample Book Title", 19.99, "Sample comments about the book.");
    private final OrderItemDTO orderItemDTO1 = new OrderItemDTO(orderDTO1, bookDTO, 20.5, "comment1", 1);
    private final OrderItemDTO orderItemDTO2 = new OrderItemDTO(orderDTO1, bookDTO, 25.0, "comment2", 1);

    @Test
    @DisplayName("find all order items test...")
    public void findAllOrderItems() throws Exception {
        List orderItems = List.of(orderItemDTO1, orderItemDTO2);
        Mockito.when(service.findAll()).thenReturn(orderItems);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL)
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(orderItems)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find 1'st order item test...")
    public void findFirstOrderItem() throws Exception {
        Mockito.when(service.findByKey(1)).thenReturn(orderItemDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(orderItemDTO1)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("find non-existing user item test...")
    public void findFalseOrderItem() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/777")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new NotFoundError("Such object was not found!"))))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new orderItem without id test...")
    public void saveNewOrderItemWithoutId() throws Exception {
        Mockito.when(service.save(orderItemDTO1)).thenReturn(orderItemDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderItemDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Save successful!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("save new orderItem with id test...")
    public void saveNewOrderItemWithId() throws Exception {
        orderItemDTO1.setId(1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderItemDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is unexpected here!!!"))))
                .andDo(MockMvcResultHandlers.print());

        orderItemDTO1.setId(null);
    }

    @Test
    @DisplayName("update 1'st order item test...")
    public void updateFirstOrderItem() throws Exception {
        Mockito.when(service.update(1, orderItemDTO1)).thenReturn(orderItemDTO1);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.patch(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderItemDTO1)));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Update successful!"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("delete 1'st order item test...")
    public void deleteFirstOrderItem() throws Exception {
        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.delete(URL + "/1")
                .characterEncoding(StandardCharsets.UTF_8));

        actions.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string("Delete successful!"))
                .andDo(MockMvcResultHandlers.print());
    }
}
