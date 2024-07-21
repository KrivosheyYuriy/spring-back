package com.example.back.controllers;

import com.example.back.domain.response.RestApiResponse;
import com.example.back.dto.Genre.GenreDto;
import com.example.back.models.Book;
import com.example.back.models.Genre;
import com.example.back.service.impl.GenreServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    /**
     * @author: YDKrivoshey
     * @date: 21.07.2024
     */
    @Autowired
    private GenreServiceImpl genreService;

    @PostMapping("")
    public RestApiResponse createGenre(@RequestBody @Valid GenreDto genre){
        Genre saved = genreService.addGenre(genre);
        return new RestApiResponse("Жарн успешно добавлен",
                new ResponseEntity<>(saved, HttpStatus.CREATED));
    }

    @PostMapping("/{genreId}/{bookId}")
    public RestApiResponse addBookToGenre(@PathVariable Long genreId, @PathVariable Long bookId){
        Book addedBook = genreService.addBookToGenre(genreId, bookId);
        return new RestApiResponse("Книга успешно добавлена к жанру",
                new ResponseEntity<>(addedBook, HttpStatus.CREATED));
    }

    @DeleteMapping("/{genreId}/{bookId}")
    public RestApiResponse deleteBookFromGenre(@PathVariable Long genreId, @PathVariable Long bookId){
        Book removedBook = genreService.removeBookFromGenre(genreId, bookId);
        return new RestApiResponse("Книга успешно убрана из жанра",
                new ResponseEntity<>(removedBook, HttpStatus.OK));
    }

    @DeleteMapping("/{genreId}")
    public RestApiResponse deleteGenre(@PathVariable Long genreId){
        Genre deleted = genreService.deleteGenreById(genreId);
        return new RestApiResponse("Жанр успешно удален",
                new ResponseEntity<>(deleted, HttpStatus.OK));
    }

    @PutMapping("/{genreId}")
    public RestApiResponse updateGenre(@PathVariable Long genreId, @RequestBody @Valid GenreDto genre){
        Genre updated = genreService.updateGenre(genreId, genre);
        return new RestApiResponse("Жанр успешно обновлен",
                new ResponseEntity<>(updated, HttpStatus.OK));
    }

    @GetMapping("/{genreId}/books")
    public RestApiResponse getAllGenreBooks(@PathVariable Long genreId) {
        return new RestApiResponse("Книги жанра", genreService.getBooksByGenreId(genreId));
    }

    @GetMapping("/{genreId}")
    public RestApiResponse getGenreDescription(@PathVariable Long genreId) {
        return new RestApiResponse("Описание жанра", genreService.getGenreDescription(genreId));
    }

}
