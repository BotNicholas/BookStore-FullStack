package org.teamwork.spring.bookstoremvcrest.mapper.abstraction;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teamwork.spring.bookstoremvcrest.model.dto.DefaultDTO;

@Component
public class AbstractMapperImpl implements AbstractMapper {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public <D extends DefaultDTO, E> E toEntity(D dto, Class<E> entity) {
        return (dto == null) ? null : modelMapper.map(dto, entity);
    }

    @Override
    public <D extends DefaultDTO, E> D toDTO(E entity, Class<D> dto) {
        return (entity == null) ? null : modelMapper.map(entity, dto);
    }
}
