package org.teamwork.spring.bookstoremvcrest.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.security.model.BookStoreUser;

import java.util.Optional;

@Repository
public interface BookStoreUserRepository extends JpaRepository<BookStoreUser, Integer> {
    Optional<BookStoreUser> findByUsername(String username);
    Optional<BookStoreUser> findByCostumer(Costumer costumer);
}
