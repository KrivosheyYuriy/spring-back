package com.example.back.service.impl;

import com.example.back.convertor.AuthorMapper;
import com.example.back.dto.Author.AuthorDto;
import com.example.back.models.Author;
import com.example.back.models.Book;
import com.example.back.repo.AuthorRepo;
import com.example.back.domain.exception.InvalidDataException;
import com.example.back.domain.exception.NotFoundException;
import com.example.back.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@Service // указывает, что тут прописана бизнес-логика
public class AuthorServiceImpl implements AuthorService {
    @Autowired // автосопряжение с репозиторием
    private AuthorRepo authorRepo;

    @Override
    public AuthorDto getAuthor(Long id){
        Optional<Author> author = authorRepo.findById(id);
        if (author.isEmpty()) {
            throw new NotFoundException("Автор не найден!");
        }
        return AuthorMapper.mapToAuthorDto(author.get());
    }

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto){;
        Author author = authorRepo.save(AuthorMapper.mapToAuthor(authorDto));
        return AuthorMapper.mapToAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorDto author){
        Author authorDB = authorRepo.findById(id).orElseThrow(() -> new NotFoundException("Автор не найден!"));
        authorDB.setName(author.getName());
        authorDB.setSurname(author.getSurname());
        authorDB.setFatherName(author.getFatherName());
        authorDB.setDescription(author.getDescription());
        authorRepo.save(authorDB);
        return AuthorMapper.mapToAuthorDto(authorDB);
    }

    public AuthorDto deleteAuthorByID(Long id) {
        if (authorRepo.findById(id).isPresent()) {
            if (getBooks(id).isEmpty()) {
                Author author = authorRepo.findById(id).get();
                AuthorDto authorDto = AuthorMapper.mapToAuthorDto(author);
                authorRepo.deleteById(id);
                return authorDto;
            }
            throw new InvalidDataException("У этого автора есть книги!");
        }
        throw new NotFoundException("Автор не найден!");
    }

    @Override
    public Set<Book> getBooks(Long id) {
        if (authorRepo.findById(id).isPresent()) {
            Author author =  authorRepo.findById(id).get();
            return author.getBooks();
        }
        throw new NotFoundException("Автор не найден!");
    }

}
