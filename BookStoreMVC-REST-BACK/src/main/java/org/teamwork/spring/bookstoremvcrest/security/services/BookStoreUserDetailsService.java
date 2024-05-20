//package org.teamwork.spring.bookstoremvcrest.security.services;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.teamwork.spring.bookstoremvcrest.security.details.BookStoreUserDetails;
//import org.teamwork.spring.bookstoremvcrest.security.repositories.BookStoreUserRepository;
//
//@Service
//public class BookStoreUserDetailsService implements UserDetailsService {
//    private final BookStoreUserRepository repository;
//
//    public BookStoreUserDetailsService(BookStoreUserRepository repository) {
//        this.repository = repository;
//    }
//
//    @Overridea
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new BookStoreUserDetails(repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Such user was not found!")));
//    }
//}
