package com.example.back.controllers;

import com.example.back.domain.response.RestApiResponse;
import com.example.back.dto.Publishing.PublishingDto;
import com.example.back.models.Book;
import com.example.back.models.Publishing;
import com.example.back.service.impl.PublishingServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishing")
public class PublishingController {
    @Autowired
    private PublishingServiceImpl publishingService;

    @GetMapping("/{publishingId}")
    public RestApiResponse getPublishing(@PathVariable Long publishingId){
        Publishing publishing = publishingService.getPublishingById(publishingId);
        return new RestApiResponse("Издательство найдено", publishing);
    }

    @GetMapping("/{publishingId}/books")
    public RestApiResponse getPublishingBooks(@PathVariable Long publishingId){
        return new RestApiResponse("Книги издательства", publishingService.getBooks(publishingId));
    }

    @PostMapping("")
    public RestApiResponse createPublishing(@RequestBody @Valid PublishingDto publishing){
        Publishing saved = publishingService.addPublishing(publishing);
        return new RestApiResponse("Издательство успешно добавлено",
                new ResponseEntity<>(saved, HttpStatus.CREATED));
    }

    @PostMapping("/{publishingId}/{bookId}")
    public RestApiResponse addBookToPublishing(@PathVariable Long publishingId, @PathVariable Long bookId) {
        Book savedBook = publishingService.addBookToPublishing(publishingId, bookId);
        return new RestApiResponse("Книга успешно добавлена к издательству",
                new ResponseEntity<>(savedBook, HttpStatus.CREATED));
    }

    @PutMapping("/{publishingId}")
    public RestApiResponse updatePublishing(@RequestBody @Valid PublishingDto publishing,
                                 @PathVariable Long publishingId){
        Publishing updated = publishingService.updatePublishing(publishingId, publishing);
        return new RestApiResponse("Издательство успешно обнолвено",
                new ResponseEntity<>(updated, HttpStatus.OK));
    }

    @DeleteMapping("/{publishingId}")
    public RestApiResponse deletePublishing(@PathVariable Long publishingId){
        Publishing deleted = publishingService.deletePublishingById(publishingId);
        return new RestApiResponse("Книга успешно удалена",
                new ResponseEntity<>(deleted, HttpStatus.OK));
    }

    @DeleteMapping("/{publishingId}/{bookId}")
    public RestApiResponse removeBookFromPublishing(@PathVariable Long publishingId, @PathVariable Long bookId) {
        Book removedBook = publishingService.removeBookFromPublishing(publishingId, bookId);
        return new RestApiResponse("Книга успешно убрана из издательства",
                new ResponseEntity<>(removedBook, HttpStatus.OK));
    }
}
