//package org.teamwork.spring.bookstoremvcrest.controller.orderitem;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.teamwork.spring.bookstoremvcrest.controller.OrderItemController;
//import org.teamwork.spring.bookstoremvcrest.model.dto.*;
//import org.teamwork.spring.bookstoremvcrest.service.impl.OrderItemServiceImpl;
//
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//
//import static org.teamwork.spring.bookstoremvcrest.controller.AuthenticationTestsConstants.costumer;
//import static org.teamwork.spring.bookstoremvcrest.controller.AuthenticationTestsConstants.userDetails;
//import static org.teamwork.spring.bookstoremvcrest.controller.orderitem.OrderItemControllerTestConstants.URL;
//
//@AutoConfigureMockMvc
//@WebMvcTest(controllers = OrderItemController.class)
//public class AuthorizedOrderItemControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private OrderItemServiceImpl service;
//
//    private final CostumerDTO costumerDTO1 = new CostumerDTO(1, "1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com");
//    private final OrderDTO orderDTO1 = new OrderDTO(costumerDTO1, new Date(), 10.0, List.of(1));
//    private final AuthorDTO authorDTO = new AuthorDTO("a", "ab", "ab", LocalDate.of(2000, 04, 23), "M", "+37379344245", "sport analyst");
//    private final BookCategoryDTO bookCategoryDTO = new BookCategoryDTO("lots of plot-twists");
//    private final BookDTO bookDTO = new BookDTO(authorDTO, bookCategoryDTO, "123-4-22-234567-1", LocalDate.of(2000, 04, 23), LocalDate.of(2005, 04, 28), "Sample Book Title", 19.99, "Sample comments about the book.");
//    private final OrderItemDTO orderItemDTO1 = new OrderItemDTO(orderDTO1, bookDTO, 20.5, "comment1");
//    private final OrderItemDTO orderItemDTO2 = new OrderItemDTO(orderDTO1, bookDTO, 25.0, "comment2");
//
//    @Test
//    @DisplayName("get order items for authenticated user test...")
//    public void getOrderItemsForCurrentUser() throws Exception {
//        List orderItems = List.of(orderItemDTO1, orderItemDTO2);
//        Mockito.when(service.findAllByCostumer(costumer)).thenReturn(orderItems);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/my")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null))));
//
//        actions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(orderItems)))
//                .andDo(MockMvcResultHandlers.print());
//    }
//}
