//package org.teamwork.spring.bookstoremvcrest.controller.costumer;
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
//import org.teamwork.spring.bookstoremvcrest.controller.CostumerController;
//import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
//import org.teamwork.spring.bookstoremvcrest.service.impl.CostumerServiceImpl;
//
//import static org.teamwork.spring.bookstoremvcrest.controller.AuthenticationTestsConstants.userDetails;
//import static org.teamwork.spring.bookstoremvcrest.controller.costumer.CostumerControllerTestConstants.URL;
//
//@AutoConfigureMockMvc(addFilters = true)
//@WebMvcTest(controllers = CostumerController.class)
//@DisplayName("Authorized Costumer Controller Test")
//public class AuthorizedCostumerControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private CostumerServiceImpl costumerService;
//
//    private final CostumerDTO costumerDTO = new CostumerDTO(1, "1000000000000", "test costumer1", "test address1", "+37310000000", "example1@gmail.com");
//
//    @Test
//    @DisplayName("obtaining current user's costumer info...")
//    public void getMyCostumerTest() throws Exception {
//        Mockito.when(costumerService.findByKey(1)).thenReturn(costumerDTO);
//
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/me")
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null))));
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(costumerDTO)))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    @DisplayName("updating current users' costumer info...")
//    public void updateMyCostumerTest() throws Exception {
//        Mockito.when(costumerService.update(1, costumerDTO)).thenReturn(costumerDTO);
//
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.patch(URL + "/me")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(costumerDTO))
//                .with(SecurityMockMvcRequestPostProcessors.authentication(new UsernamePasswordAuthenticationToken(userDetails, null, null)))
//                .with(SecurityMockMvcRequestPostProcessors.csrf()));
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Success!"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//}
