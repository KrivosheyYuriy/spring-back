package com.example.back.controllers;

import com.example.back.domain.response.RestApiResponse;
import com.example.back.dto.Book.BookDto;
import com.example.back.models.Book;
import com.example.back.service.impl.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @PostMapping("")
    public RestApiResponse addBook(@RequestBody Book book) {
        Book saved = bookService.addBook(book);
        return new RestApiResponse("Книга успешно сохранена",
                new ResponseEntity<>(saved, HttpStatus.CREATED));
    }

    @GetMapping("/{bookId}")
    public RestApiResponse getBook(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);
        return new RestApiResponse("Книга успешно найдена", book);
    }

    @PutMapping("/{bookId}")
    public RestApiResponse updateBook(@PathVariable Long bookId, @RequestBody @Valid BookDto book) {
        Book updatedBook = bookService.updateBook(bookId, book);
        return new RestApiResponse("Книга успешно обновлена",
                new ResponseEntity<>(updatedBook, HttpStatus.OK));
    }

    @DeleteMapping("/{bookId}")
    public RestApiResponse deleteBook(@PathVariable Long bookId) {
        return new RestApiResponse("Книга успешно удалена",
                bookService.deleteBookById(bookId));
    }
}
