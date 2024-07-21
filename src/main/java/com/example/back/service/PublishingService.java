package com.example.back.service;

import com.example.back.dto.Publishing.PublishingDto;
import com.example.back.models.Book;
import com.example.back.models.Publishing;

import java.util.List;

public interface PublishingService {
    public Publishing addPublishing(PublishingDto publishingDto);
    public Publishing updatePublishing(Long id, PublishingDto publishingDto);
    public Publishing deletePublishingById(Long id);
    public List<Book> getBooks(Long id);
    public Publishing getPublishingById(Long id);
}
