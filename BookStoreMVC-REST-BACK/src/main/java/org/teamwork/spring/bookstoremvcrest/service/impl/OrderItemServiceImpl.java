package org.teamwork.spring.bookstoremvcrest.service.impl;

import org.springframework.stereotype.Service;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.mapper.abstraction.AbstractMapper;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.model.OrderItem;
import org.teamwork.spring.bookstoremvcrest.model.dto.OrderItemDTO;
import org.teamwork.spring.bookstoremvcrest.repository.OrderItemRepository;
import org.teamwork.spring.bookstoremvcrest.service.DefaultService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements DefaultService<OrderItemDTO, OrderItem, Integer> {
    private final OrderItemRepository orderItemRepository;
    private final OrderServiceImpl orderService;
    private final AbstractMapper mapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderServiceImpl orderService, AbstractMapper mapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @Override
    public List<OrderItemDTO> findAll() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems.stream().map(orderItem -> mapper.toDTO(orderItem, OrderItemDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO findByKey(Integer key) {
        return mapper.toDTO(orderItemRepository.findById(key), OrderItemDTO.class);
    }

    public List<OrderItemDTO> findAllByCostumer(Costumer costumer) {
        List<OrderItem> orderItems = orderItemRepository.findAllByOrder_Costumer(costumer);
        return orderItems.stream().map(orderItem -> mapper.toDTO(orderItem, OrderItemDTO.class)).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO save(OrderItemDTO obj) {
        OrderItem orderItem = orderItemRepository.save(mapper.toEntity(obj, OrderItem.class));
        orderService.recalculateValueFor(orderItem.getOrder());
        return mapper.toDTO(orderItem, OrderItemDTO.class);
    }

    @Override
    public OrderItemDTO update(Integer key, OrderItemDTO obj) {
        OrderItem orderItem = mapper.toEntity(obj, OrderItem.class);
        orderItem.setId(key);
        orderItem = orderItemRepository.save(orderItem);
        orderService.recalculateValueFor(orderItem.getOrder());
        return mapper.toDTO(orderItem, OrderItemDTO.class);
    }

    @Override
    public void delete(Integer key) throws NotFoundException {
        OrderItem orderItem = this.orderItemRepository.findById(key).orElseThrow(()->new NotFoundException("Such orderItem was not found!"));
        orderItemRepository.deleteById(key);
        orderService.recalculateValueFor(orderItem.getOrder());
    }
}
