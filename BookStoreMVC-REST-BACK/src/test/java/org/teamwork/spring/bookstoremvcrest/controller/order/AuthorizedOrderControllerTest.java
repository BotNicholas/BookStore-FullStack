//package org.teamwork.spring.bookstoremvcrest.controller.order;
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
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.teamwork.spring.bookstoremvcrest.controller.OrderController;
//import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
//import org.teamwork.spring.bookstoremvcrest.model.dto.FullOrderDTO;
//import org.teamwork.spring.bookstoremvcrest.model.dto.LightOrderItemDTO;
//import org.teamwork.spring.bookstoremvcrest.model.dto.MyFullOrderDTO;
//import org.teamwork.spring.bookstoremvcrest.service.impl.OrderServiceImpl;
//import org.teamwork.spring.bookstoremvcrest.utils.UsedIdError;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.List;
//
//import static org.teamwork.spring.bookstoremvcrest.controller.AuthenticationTestsConstants.costumer;
//import static org.teamwork.spring.bookstoremvcrest.controller.AuthenticationTestsConstants.userDetails;
//import static org.teamwork.spring.bookstoremvcrest.controller.order.OrderControllerTestConstants.URL;
//
//@AutoConfigureMockMvc
//@WebMvcTest(controllers = OrderController.class)
//public class AuthorizedOrderControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private OrderServiceImpl service;
//
//    private final CostumerDTO costumerDTO1 = new CostumerDTO(1, "1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com");
//    private final LightOrderItemDTO lightOrderItemDTO1 = new LightOrderItemDTO(1, 20.0, "comment 1");
//    private final FullOrderDTO fullOrderDTO1 = new FullOrderDTO(costumerDTO1, new Date(), 12.0, List.of(lightOrderItemDTO1));
//    private final FullOrderDTO fullOrderDTO2 = new FullOrderDTO(costumerDTO1, new Date(), 21.0, List.of(lightOrderItemDTO1));
//
//    @Test
//    @DisplayName("get authorized user's orders test...")
//    public void getUserOrders() throws Exception {
//        List<FullOrderDTO> orders = List.of(fullOrderDTO1, fullOrderDTO2);
//        Mockito.when(service.findAllByCostumer(costumer)).thenReturn(orders);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/my")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null))));
//
//        actions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(orders)))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("add new order without id for authorized user test...")
//    public void saveOrderWithoutIdForUser() throws Exception {
//        MyFullOrderDTO myFullOrderDTO = new MyFullOrderDTO();
//        myFullOrderDTO.setId(fullOrderDTO1.getId());
//        myFullOrderDTO.setOrderDate(fullOrderDTO1.getOrderDate());
//        myFullOrderDTO.setOrderValue(fullOrderDTO1.getOrderValue());
//        myFullOrderDTO.setCostumer(fullOrderDTO1.getCostumer());
//        myFullOrderDTO.setItemList(fullOrderDTO1.getItemList());
//
//        Mockito.when(service.saveForCustomer(myFullOrderDTO, costumer)).thenReturn(fullOrderDTO1);
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL + "/my")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(myFullOrderDTO))
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null)))
//                .with(SecurityMockMvcRequestPostProcessors.csrf()));
//
//        actions.andExpect(MockMvcResultMatchers.status().isAccepted())
//                .andExpect(MockMvcResultMatchers.content().string("Success!"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("add new order with id for authorized user test...")
//    public void saveOrderWithIdForUser() throws Exception {
//        MyFullOrderDTO myFullOrderDTO = new MyFullOrderDTO();
//        myFullOrderDTO.setId(1);
//        myFullOrderDTO.setOrderDate(fullOrderDTO1.getOrderDate());
//        myFullOrderDTO.setOrderValue(fullOrderDTO1.getOrderValue());
//        myFullOrderDTO.setCostumer(fullOrderDTO1.getCostumer());
//        myFullOrderDTO.setItemList(fullOrderDTO1.getItemList());
//
//        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(URL + "/my")
//                .characterEncoding(StandardCharsets.UTF_8)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(myFullOrderDTO))
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null)))
//                .with(SecurityMockMvcRequestPostProcessors.csrf()));
//
//        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(new UsedIdError("Id is unexpected here!"))))
//                .andDo(MockMvcResultHandlers.print());
//    }
//}
