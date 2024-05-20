package org.teamwork.spring.bookstoremvcrest.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.mapper.abstraction.AbstractMapper;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.model.dto.CostumerDTO;
import org.teamwork.spring.bookstoremvcrest.security.model.BookStoreUser;
import org.teamwork.spring.bookstoremvcrest.security.repositories.BookStoreUserRepository;
import org.teamwork.spring.bookstoremvcrest.service.DefaultService;
import org.teamwork.spring.bookstoremvcrest.repository.CostumerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostumerServiceImpl implements DefaultService<CostumerDTO, Costumer, Integer> {
    private final CostumerRepository costumerRepository;
    private final BookStoreUserRepository userRepository;
    private final AbstractMapper mapper;

    public CostumerServiceImpl(CostumerRepository costumerRepository, BookStoreUserRepository userRepository, AbstractMapper mapper) {
        this.costumerRepository = costumerRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CostumerDTO> findAll() {
        List<Costumer> costumers = costumerRepository.findAll();
        return costumers.stream().map(costumer -> mapper.toDTO(costumer, CostumerDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CostumerDTO findByKey(Integer key) {
        return mapper.toDTO(costumerRepository.findById(key), CostumerDTO.class);
    }

    @Override
    public CostumerDTO save(CostumerDTO obj) {
        Costumer costumer = costumerRepository.save(mapper.toEntity(obj, Costumer.class));
        return mapper.toDTO(costumer, CostumerDTO.class);
    }

    @Override
    public CostumerDTO update(Integer key, CostumerDTO obj) {
        Costumer costumer = mapper.toEntity(obj, Costumer.class);
        costumer.setId(key);
        costumerRepository.save(costumer);
        return mapper.toDTO(costumer, CostumerDTO.class);
    }

    /**
     * Here logic is next:
     * Every user is related with costumer.
     * If costumer is deleted we must assign new one to user
     *
     * Also method must be transactional!
     */
    @Override
    @Transactional
    public void delete(Integer key) throws NotFoundException {
        Costumer costumer = costumerRepository.findById(key).orElseThrow(()-> new NotFoundException("Such costumer does not exist!"));

        userRepository.findByCostumer(costumer).ifPresent(user -> {
            Costumer newCostumer = costumerRepository.save(new Costumer(user.getUsername()));
            user.setCostumer(newCostumer);
        });

        costumerRepository.deleteById(key);
    }
}
