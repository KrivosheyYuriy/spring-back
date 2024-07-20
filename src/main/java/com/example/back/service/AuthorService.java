package com.example.back.service;

import com.example.back.dto.Author.AuthorDto;
import com.example.back.models.Author;
import com.example.back.models.Book;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    public AuthorDto getAuthor(Long id);
    public AuthorDto addAuthor(AuthorDto author);
    public AuthorDto updateAuthor(Long id, AuthorDto author);
    public AuthorDto deleteAuthorByID(Long id);
    public Set<Book> getBooks(Long id);
}
