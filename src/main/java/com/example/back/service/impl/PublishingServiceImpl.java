package com.example.back.service.impl;

import com.example.back.convertor.PublishingConvertor;
import com.example.back.domain.exception.HasDependenciesException;
import com.example.back.domain.exception.InvalidDataException;
import com.example.back.domain.exception.NotFoundException;
import com.example.back.dto.Publishing.PublishingDto;
import com.example.back.models.Book;
import com.example.back.models.Publishing;
import com.example.back.repo.BookRepo;
import com.example.back.repo.PublishingRepo;
import com.example.back.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingServiceImpl implements PublishingService {
    @Autowired
    PublishingRepo publishingRepo;

    @Autowired
    BookRepo bookRepo;

    @Override
    public Publishing addPublishing(PublishingDto publishingDto) {
        return publishingRepo.save(PublishingConvertor.mapToPublishing(publishingDto));
    }

    @Override
    public Publishing updatePublishing(Long id, PublishingDto publishingDto) {
        Publishing publishingDb = publishingRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Издательство не найдено"));
        publishingDb.setTitle(publishingDto.getTitle());
        publishingDb.setDescription(publishingDto.getDescription());
        publishingDb.setPhone(publishingDto.getPhone());
        publishingDb.setEmail(publishingDto.getEmail());
        return publishingDb;
    }

    @Override
    public Publishing deletePublishingById(Long id) {
        if (publishingRepo.findById(id).isPresent()){
            if (getBooks(id).isEmpty()) {
                Publishing publishing = publishingRepo.findById(id).get();
                publishingRepo.deleteById(id);
                return publishing;
            }
            throw new HasDependenciesException("У этого издательства есть книги!");
        }
        throw new NotFoundException("Издательство не найдено");
    }

    @Override
    public Publishing getPublishingById(Long id) {
        if (publishingRepo.findById(id).isPresent()){
            return publishingRepo.findById(id).get();
        }
        throw new NotFoundException("Издательство не найдено");
    }

    @Override
    public List<Book> getBooks(Long id){
        if (bookRepo.findById(id).isPresent()){
            return bookRepo.findBooksByPublishingId(id);
        }
        throw new NotFoundException("Издательство не найдено");
    }

    public Book addBookToPublishing(Long publishingId, Long bookId){
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена"));
        Publishing publishing = publishingRepo.findById(publishingId).
                orElseThrow(() -> new NotFoundException("Издательство не найдено"));
        book.addBookToPublishing(publishing);
        return bookRepo.save(book);
    }

    public Book removeBookFromPublishing(Long publishingId, Long bookId){
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new NotFoundException("Книга не найдена"));
        Publishing publishing = publishingRepo.findById(publishingId).
                orElseThrow(() -> new NotFoundException("Издательство не найдено"));
        book.removeBookFromPublishing(publishing);
        return bookRepo.save(book);
    }
}
