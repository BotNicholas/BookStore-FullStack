package org.teamwork.spring.bookstoremvcrest.security.services;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.mapper.abstraction.AbstractMapperImpl;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.repository.CostumerRepository;
import org.teamwork.spring.bookstoremvcrest.security.model.BookStoreUser;
import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreRegistrationUserDTO;
import org.teamwork.spring.bookstoremvcrest.security.model.dto.BookStoreUserDTO;
import org.teamwork.spring.bookstoremvcrest.security.repositories.BookStoreUserRepository;
import org.teamwork.spring.bookstoremvcrest.service.DefaultService;
import org.teamwork.spring.bookstoremvcrest.utils.FilesHandler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookStoreUserServiceImpl implements DefaultService<BookStoreUserDTO, BookStoreUser, Integer> {
    @Value("${images.users.path}")
    private String usersImagesFolder;

    private final BookStoreUserRepository repository;
    private final CostumerRepository costumerRepository;
    private final AbstractMapperImpl mapper;

    public BookStoreUserServiceImpl(BookStoreUserRepository repository, CostumerRepository costumerRepository, AbstractMapperImpl mapper) {
        this.repository = repository;
        this.costumerRepository = costumerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BookStoreUserDTO> findAll() {
        return repository.findAll().stream().map(user -> mapper.toDTO(user, BookStoreUserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BookStoreUserDTO findByKey(Integer key) {
        return mapper.toDTO(repository.findById(key).orElseThrow(null), BookStoreUserDTO.class);
    }

    public BookStoreUserDTO findByUsername(String username) {
        return mapper.toDTO(repository.findByUsername(username), BookStoreUserDTO.class);
    }

    private BookStoreUserDTO save(BookStoreUser user) {
        if (user.getCostumer() == null) {
            Costumer costumerForUser = costumerRepository.save(new Costumer(user.getUsername()));
            user.setCostumer(costumerForUser);
        }
        user = repository.save(user);
        return mapper.toDTO(user, BookStoreUserDTO.class);
    }

    @Override
    public BookStoreUserDTO save(BookStoreUserDTO obj) {
        BookStoreUser user = mapper.toEntity(obj, BookStoreUser.class);
        return save(user);
    }

    public BookStoreUserDTO saveWithPhoto(BookStoreUserDTO obj, MultipartFile photo) throws IOException {
        String savedFileName = FilesHandler.saveFile(usersImagesFolder+photo.getOriginalFilename(), photo.getBytes());
        if (!photo.getOriginalFilename().equals(savedFileName)) {
            obj.setImage(savedFileName);
        }

        return save(mapper.toEntity(obj, BookStoreUser.class));
    }

    public BookStoreUserDTO register(BookStoreRegistrationUserDTO registrationUserDTO) {
        BookStoreUser bookStoreUser = mapper.toEntity(registrationUserDTO, BookStoreUser.class);
        bookStoreUser.setRoles("ROLE_USER");
        return save(bookStoreUser);
    }

    @Override
    public BookStoreUserDTO update(Integer key, BookStoreUserDTO obj) {
        BookStoreUser user = mapper.toEntity(obj, BookStoreUser.class);
        user.setId(key);
        repository.save(user);
        costumerRepository.save(user.getCostumer());//
        return mapper.toDTO(user, BookStoreUserDTO.class);
    }

    public BookStoreUserDTO updateWithPhoto(Integer id, BookStoreUserDTO obj, MultipartFile photo) throws NotFoundException, IOException {
        BookStoreUser user = repository.findById(id).orElseThrow(()->new NotFoundException("Such User does not exist!"));
        String savedImageName = FilesHandler.updateFile(usersImagesFolder+user.getImage(), usersImagesFolder + photo.getOriginalFilename(), photo.getBytes());

        if (!photo.getOriginalFilename().equals(savedImageName)){
            obj.setImage(savedImageName);
        }

        user = mapper.toEntity(obj, BookStoreUser.class);
        user.setId(id);
        user = repository.save(user);

        return mapper.toDTO(user, BookStoreUserDTO.class);
    }

    public BookStoreUserDTO update(String username, BookStoreUserDTO obj) {
//        BookStoreUser user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Such user was not found!"));
        BookStoreUser user = repository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Such user was not found!"));
        BookStoreUser updatedUser = mapper.toEntity(obj, BookStoreUser.class);
        updatedUser.setId(user.getId());
        repository.save(updatedUser);
        costumerRepository.save(updatedUser.getCostumer());//
        return mapper.toDTO(updatedUser, BookStoreUserDTO.class);
    }

    @Override
    public void delete(Integer key) {
        BookStoreUser user = repository.findById(key).orElseThrow(() -> new IllegalArgumentException("Such user does no exist!"));

        FilesHandler.deleteFile(usersImagesFolder + user.getImage());

        repository.deleteById(key);
        costumerRepository.deleteById(user.getCostumer().getId());
    }
}
