package com.example.back.service.impl;

import com.example.back.convertor.AuthorMapper;
import com.example.back.domain.exception.HasDependenciesException;
import com.example.back.dto.Author.AuthorDto;
import com.example.back.dto.Book.BookDto;
import com.example.back.models.Author;
import com.example.back.models.Book;
import com.example.back.repo.AuthorRepo;
import com.example.back.domain.exception.InvalidDataException;
import com.example.back.domain.exception.NotFoundException;
import com.example.back.repo.BookRepo;
import com.example.back.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service // указывает, что тут прописана бизнес-логика
public class AuthorServiceImpl implements AuthorService {
    @Autowired // автосопряжение с репозиторием
    private AuthorRepo authorRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Author getAuthor(Long id){
        if (authorRepo.findById(id).isPresent()){
            return authorRepo.findById(id).get();
        }
        throw new NotFoundException("Автор не найден");
    }

    @Override
    public Author addAuthor(AuthorDto authorDto){;
        return authorRepo.save(AuthorMapper.mapToAuthor(authorDto));
    }

    @Override
    public Author updateAuthor(Long id, AuthorDto author){
        Author authorDB = authorRepo.findById(id).orElseThrow(() -> new NotFoundException("Автор не найден!"));
        authorDB.setName(author.getName());
        authorDB.setSurname(author.getSurname());
        authorDB.setFatherName(author.getFatherName());
        authorDB.setDescription(author.getDescription());
        authorRepo.save(authorDB);
        return authorDB;
    }

    public Author deleteAuthorByID(Long id) {
        if (authorRepo.findById(id).isPresent()) {
            if (getBooks(id).isEmpty()) {
                Author author = authorRepo.findById(id).get();
                authorRepo.deleteById(id);
                return author;
            }
            throw new HasDependenciesException("У этого автора есть книги!");
        }
        throw new NotFoundException("Автор не найден!");
    }

    @Override
    public List<Book> getBooks(Long id) {
        if (authorRepo.findById(id).isPresent()) {
            return bookRepo.findBooksByAuthorsId(id);
        }
        throw new NotFoundException("Автор не найден!");
    }

    public Book addBookToAuthor(Long authorId, Long bookId){
        Author author = authorRepo.findById(authorId).orElseThrow(() -> new NotFoundException("Автор не найден!"));
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена!"));
        book.addAuthor(author);
        return bookRepo.save(book);
    }

    public Book removeBookFromAuthor(Long authorId, Long bookId){
        Author author = authorRepo.findById(authorId).orElseThrow(() -> new NotFoundException("Автор не найден!"));
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена!"));
        book.removeAuthor(author);
        return bookRepo.save(book);
    }

}
