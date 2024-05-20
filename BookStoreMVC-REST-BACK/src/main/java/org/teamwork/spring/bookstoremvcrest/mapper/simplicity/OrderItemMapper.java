package org.teamwork.spring.bookstoremvcrest.mapper.simplicity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teamwork.spring.bookstoremvcrest.model.OrderItem;
import org.teamwork.spring.bookstoremvcrest.model.dto.OrderItemDTO;

@Component
public class OrderItemMapper implements DefaultMapper<OrderItemDTO, OrderItem> {
    @Autowired
    private ModelMapper mapper;

    @Override
    public OrderItem toEntity(OrderItemDTO dto) {
        return (dto == null) ? null : mapper.map(dto, OrderItem.class);
    }

    @Override
    public OrderItemDTO toDTO(OrderItem entity) {
        return (entity == null) ? null : mapper.map(entity, OrderItemDTO.class);
    }
}
