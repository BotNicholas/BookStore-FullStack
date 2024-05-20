package org.teamwork.spring.bookstoremvcrest.mapper.simplicity;

import org.teamwork.spring.bookstoremvcrest.model.dto.DefaultDTO;

public interface DefaultMapper<D extends DefaultDTO, E> {
    E toEntity(D dto);

    D toDTO(E entity);
}
