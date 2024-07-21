package com.example.back.controllers;

import com.example.back.domain.exception.RestApiException;
import com.example.back.domain.response.RestApiResponse;
import com.example.back.dto.Author.AuthorDto;
import com.example.back.models.Author;
import com.example.back.models.Book;
import com.example.back.service.impl.AuthorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    /**
     * @author: YDKrivoshey
     * @date: 21.07.2024
     */
    @Autowired
    private AuthorServiceImpl authorService;

    @GetMapping("/{authorId}")
    public RestApiResponse getAuthor(@PathVariable Long authorId) {
        Author author = authorService.getAuthor(authorId);
        return new RestApiResponse("Автор наден", author);
    }

    @GetMapping("/{authorId}/books")
    public RestApiResponse getBooks(@PathVariable Long authorId) {
        return new RestApiResponse("Книги автора:", authorService.getBooks(authorId));
    }

    @PostMapping("")
    public RestApiResponse createAuthor(@RequestBody @Valid AuthorDto author) {
        Author saved = authorService.addAuthor(author);
        return new RestApiResponse("Автор успешно добавлен",
                new ResponseEntity<>(saved, HttpStatus.CREATED));
    }

    @PostMapping("/{authorId}/{bookId}")
    public RestApiResponse addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        Author addedAuthor = authorService.getAuthor(authorId);
        return new RestApiResponse("Книга успешно добавлена автору",
                new ResponseEntity<>(addedAuthor, HttpStatus.CREATED));
    }

    @PutMapping("/{authorID}")
    public RestApiResponse updateAuthor(@PathVariable Long authorID, @RequestBody @Valid AuthorDto author) {
        Author updated = authorService.updateAuthor(authorID, author);
        return new RestApiResponse("Автор успешно обновлен",
                new ResponseEntity<>(updated, HttpStatus.OK));
    }

    @DeleteMapping("/{authorID}")
    public RestApiResponse deleteAuthor(@PathVariable Long authorID) {
        Author deleted = authorService.deleteAuthorByID(authorID);
        return new RestApiResponse("Автор успешно удален",
                new ResponseEntity<>(deleted, HttpStatus.OK));
    }

    @DeleteMapping("/{authorId}/{bookId}")
    public RestApiResponse removeBookFromAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        Book removedBook = authorService.removeBookFromAuthor(authorId, bookId);
        return new RestApiResponse("Книга успешно убрана из произведений автора",
                new ResponseEntity<>(removedBook, HttpStatus.OK));
    }
}
