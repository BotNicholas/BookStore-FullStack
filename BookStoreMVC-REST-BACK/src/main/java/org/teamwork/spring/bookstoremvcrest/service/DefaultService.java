package org.teamwork.spring.bookstoremvcrest.service;

import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.model.dto.DefaultDTO;

import java.util.List;

public interface DefaultService<D extends DefaultDTO, O, K extends Number> {
    List<D> findAll();

    D findByKey(K key);

    D save(D obj);

    D update(K key, D obj);

    void delete(K key) throws NotFoundException;
}
