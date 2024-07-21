package com.example.back.service;

import com.example.back.dto.Genre.GenreDto;
import com.example.back.models.Book;
import com.example.back.models.Genre;

import java.util.List;

public interface GenreService {
    public Genre addGenre(GenreDto genre);
    public Genre updateGenre(Long id, GenreDto genre);
    public String getGenreDescription(Long id);
    public Genre deleteGenreById(Long id);
    public List<Book> getBooksByGenreId(Long id);
    public Book addBookToGenre(Long genreId, Long bookId);
    public Book removeBookFromGenre(Long genreId, Long bookId);
}
