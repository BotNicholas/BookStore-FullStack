package org.teamwork.spring.bookstoremvcrest.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.model.dto.OrderItemDTO;
//import org.teamwork.spring.bookstoremvcrest.security.details.BookStoreUserDetails;
import org.teamwork.spring.bookstoremvcrest.service.impl.OrderItemServiceImpl;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    private final OrderItemServiceImpl orderItemService;

    public OrderItemController(OrderItemServiceImpl orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping()
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItemDTO> findAll() {
        return orderItemService.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public OrderItemDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        OrderItemDTO orderItemDTO = orderItemService.findByKey(id);
        if (orderItemDTO == null) {
            throw new NotFoundException();
        }
        return orderItemService.findByKey(id);
    }

    @PostMapping()
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemDTO save(@Valid @RequestBody OrderItemDTO orderItemDTO) throws UnexpectedIdException {
        if (orderItemDTO.getId() != null && orderItemDTO.getId() != 0) {
            throw new UnexpectedIdException();
        }
        return orderItemService.save(orderItemDTO);
    }

    @PatchMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public OrderItemDTO update(@Valid @RequestBody OrderItemDTO orderItemDTO, @PathVariable("id") Integer id) {
        return orderItemService.update(id, orderItemDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) throws NotFoundException {
        orderItemService.delete(id);
    }

//    @GetMapping("/my")
//    @ResponseStatus(HttpStatus.OK)
//    public List<OrderItemDTO> findMy(Authentication authentication) {
//        BookStoreUserDetails userDetails = (BookStoreUserDetails) authentication.getPrincipal();
//        return orderItemService.findAllByCostumer(userDetails.getUser().getCostumer());
//    }
}