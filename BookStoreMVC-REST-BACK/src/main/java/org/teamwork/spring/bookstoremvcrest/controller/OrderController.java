package org.teamwork.spring.bookstoremvcrest.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.model.dto.FullOrderDTO;
import org.teamwork.spring.bookstoremvcrest.model.dto.LightOrderItemDTO;
import org.teamwork.spring.bookstoremvcrest.model.dto.MyFullOrderDTO;
//import org.teamwork.spring.bookstoremvcrest.security.details.BookStoreUserDetails;
import org.teamwork.spring.bookstoremvcrest.service.impl.OrderServiceImpl;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderServiceImpl service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @GetMapping("")
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<FullOrderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public FullOrderDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        FullOrderDTO fullOrderDTO = service.findByKey(id);
        if (fullOrderDTO == null) {
            throw new NotFoundException();
        }
        return fullOrderDTO;
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public FullOrderDTO add(@Valid @RequestBody FullOrderDTO fullOrderDTO) throws UnexpectedIdException {
        if (fullOrderDTO.getId() != null && fullOrderDTO.getId() != 0) {
            throw new UnexpectedIdException("Id is not expected here");
        }
        for (LightOrderItemDTO orderItemDTO : fullOrderDTO.getItemList()) {
            if (orderItemDTO.getId() != null && orderItemDTO.getId() != 0) {
                throw new UnexpectedIdException("Id is unexpected in OrderItems!");
            }
        }
        return service.save(fullOrderDTO);
    }

    @PatchMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public FullOrderDTO update(@PathVariable("id") Integer id, @Valid @RequestBody FullOrderDTO fullOrderDTO) {
        return service.update(id, fullOrderDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

//    @GetMapping("/my")
//    @ResponseStatus(HttpStatus.OK)
//    public List<FullOrderDTO> myOrders(Authentication authentication) {
//        BookStoreUserDetails userDetails = (BookStoreUserDetails) authentication.getPrincipal();
//        return service.findAllByCostumer(userDetails.getUser().getCostumer());
//    }

//    @PostMapping("/my")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String addMyOrder(Authentication authentication, @Valid @RequestBody MyFullOrderDTO myOrderDTO) throws UnexpectedIdException { //MyOrderDTO because I add an order for me
//        if (myOrderDTO.getId() != null) {
//            throw new UnexpectedIdException("Id is unexpected here!");
//        }
//        BookStoreUserDetails userDetails = (BookStoreUserDetails) authentication.getPrincipal();
//        Costumer costumer = userDetails.getUser().getCostumer();
//        service.saveForCustomer(myOrderDTO, costumer);
//        return "Success!";
//    }
}