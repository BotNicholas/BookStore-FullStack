package org.teamwork.spring.bookstoremvcrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamwork.spring.bookstoremvcrest.model.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    public List<Contact> findAllByContactType_Code(Integer code);
}
