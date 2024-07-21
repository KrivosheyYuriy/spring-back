package com.example.back.service;

import com.example.back.dto.Author.AuthorDto;
import com.example.back.models.Author;
import com.example.back.models.Book;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    public Author getAuthor(Long id);
    public Author addAuthor(AuthorDto author);
    public Author updateAuthor(Long id, AuthorDto author);
    public Author deleteAuthorByID(Long id);
    public List<Book> getBooks(Long id);
}
