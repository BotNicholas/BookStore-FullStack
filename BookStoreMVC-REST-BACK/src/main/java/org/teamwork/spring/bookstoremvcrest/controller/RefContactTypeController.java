package org.teamwork.spring.bookstoremvcrest.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;
import org.teamwork.spring.bookstoremvcrest.model.dto.RefContactTypeDTO;
import org.teamwork.spring.bookstoremvcrest.service.impl.RefContactTypeServiceImpl;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ref-contact-types")
public class RefContactTypeController {
    private final RefContactTypeServiceImpl contactTypeService;

    public RefContactTypeController(RefContactTypeServiceImpl contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @GetMapping()
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public List<RefContactTypeDTO> findAll() {
        return contactTypeService.findAll();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public RefContactTypeDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
        RefContactTypeDTO refContactTypeDTO = contactTypeService.findByKey(id);
        if (refContactTypeDTO == null) {
            throw new NotFoundException();
        }
        return refContactTypeDTO;
    }

    @PostMapping()
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public RefContactTypeDTO save(@Valid @RequestBody RefContactTypeDTO refContactTypeDTO) throws UnexpectedIdException {
        if (refContactTypeDTO.getCode() != null && refContactTypeDTO.getCode() != 0) {
            throw new UnexpectedIdException();
        }
        return contactTypeService.save(refContactTypeDTO);
    }

    @PatchMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public RefContactTypeDTO update(@Valid @RequestBody RefContactTypeDTO refContactTypeDTO, @PathVariable("id") Integer id) {
        return contactTypeService.update(id, refContactTypeDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        contactTypeService.delete(id);
    }
}