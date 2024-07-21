package com.example.back.service.impl;

import com.example.back.convertor.GenreConvertor;
import com.example.back.domain.exception.HasDependenciesException;
import com.example.back.domain.exception.InvalidDataException;
import com.example.back.domain.exception.NotFoundException;
import com.example.back.dto.Book.BookDto;
import com.example.back.dto.Genre.GenreDto;
import com.example.back.models.Book;
import com.example.back.models.Genre;
import com.example.back.repo.BookRepo;
import com.example.back.repo.GenreRepo;
import com.example.back.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreRepo genreRepo;

    @Autowired
    BookRepo bookRepo;

    @Override
    public Genre addGenre(GenreDto genre) {
        return genreRepo.save(GenreConvertor.mapToGenre(genre));
    }

    @Override
    public Genre updateGenre(Long id, GenreDto genre) {
        Genre genreDb = genreRepo.findById(id).
                orElseThrow(() -> new NotFoundException("Жанр не найден"));
        genreDb.setName(genre.getName());
        genreDb.setDescription(genre.getDescription());
        return genreRepo.save(genreDb);
    }

    @Override
    public String getGenreDescription(Long id) {
        if (genreRepo.findById(id).isPresent()){
            return genreRepo.findById(id).get().getDescription();
        }
        throw new NotFoundException("Жанр не найден");
    }

    @Override
    public Genre deleteGenreById(Long id) {
        if (genreRepo.findById(id).isPresent()){
            if (bookRepo.findBooksByGenresId(id).isEmpty()) {
                Genre genre = genreRepo.findById(id).get();
                genreRepo.deleteById(id);
                return genre;
            }
            throw new HasDependenciesException("Существуют книги с этим жанорм");
        }
        throw new NotFoundException("Жанр не найден");
    }

    @Override
    public List<Book> getBooksByGenreId(Long id){
        return bookRepo.findBooksByGenresId(id);
    }

    @Override
    public Book addBookToGenre(Long genreId, Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена"));
        Genre genre = genreRepo.findById(genreId).orElseThrow(() -> new NotFoundException("Жанр не найден"));
        book.addGenre(genre);
        return bookRepo.save(book);
    }

    @Override
    public Book removeBookFromGenre(Long genreId, Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена"));
        Genre genre = genreRepo.findById(genreId).orElseThrow(() -> new NotFoundException("Жанр не найден"));
        book.removeGenre(genre);
        return bookRepo.save(book);
    }
}
