package org.teamwork.spring.bookstoremvcrest.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
//import org.teamwork.spring.bookstoremvcrest.security.details.BookStoreUserDetails;
import org.teamwork.spring.bookstoremvcrest.service.impl.CostumerServiceImpl;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/costumers")
public class CostumerController {
    private final CostumerServiceImpl costumerService;

    public CostumerController(CostumerServiceImpl costumerService) {
        this.costumerService = costumerService;
    }

    @GetMapping("")
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<CostumerDTO> findAll() {
        return costumerService.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public CostumerDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        CostumerDTO costumerDTO = costumerService.findByKey(id);
        if (costumerDTO == null) {
            throw new NotFoundException();
        }
        return costumerService.findByKey(id);
    }

//    @PostMapping("")
////    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String save(@Valid @RequestBody CostumerDTO costumerDTO) throws UnexpectedIdException {
//        if (costumerDTO.getId() != null) {
//            throw new UnexpectedIdException();
//        }
//        costumerService.save(costumerDTO);
//        return "Save success!";
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CostumerDTO save(@Valid @RequestBody CostumerDTO costumerDTO) throws UnexpectedIdException {
        if (costumerDTO.getId() != null && costumerDTO.getId() != 0) {
            throw new UnexpectedIdException();
        }
        return costumerService.save(costumerDTO);
    }


//
//    @PatchMapping("/{id}")
////    @PreAuthorize("hasRole('ADMIN')")
//    @ResponseStatus(HttpStatus.OK)
//    public String update(@Valid @RequestBody CostumerDTO costumerDTO, @PathVariable("id") Integer id) {
//        costumerService.update(id, costumerDTO);
//        return "Update successful!";
//    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CostumerDTO update(@Valid @RequestBody CostumerDTO costumerDTO, @PathVariable("id") Integer id) {
        return costumerService.update(id, costumerDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) throws NotFoundException {
        costumerService.delete(id);
    }

//    @GetMapping("/me")
//    @ResponseStatus(HttpStatus.OK)
//    public CostumerDTO showMe(Authentication authentication) {
//        BookStoreUserDetails userDetails = (BookStoreUserDetails) authentication.getPrincipal();
//        return costumerService.findByKey(userDetails.getUser().getCostumer().getId());
//    }

//    @PatchMapping("/me")
//    @ResponseStatus(HttpStatus.OK)
//    public String updateMe(Authentication authentication, @Valid @RequestBody CostumerDTO costumerDTO) {
//        BookStoreUserDetails user = (BookStoreUserDetails) authentication.getPrincipal();
//        costumerService.update(user.getUser().getCostumer().getId(), costumerDTO);
//        return "Success!";
//    }
}