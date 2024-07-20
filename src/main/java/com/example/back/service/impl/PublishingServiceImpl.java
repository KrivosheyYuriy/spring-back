package com.example.back.service.impl;

import com.example.back.domain.exception.NotFoundException;
import com.example.back.models.Publishing;
import com.example.back.repo.PublishingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingServiceImpl {
    @Autowired
    PublishingRepo publishingRepo;

    public Publishing addPublishing(Publishing publishing){
        return publishingRepo.save(publishing);
    }

    public Publishing updatePublishing(Long id, Publishing publishing){
        if (publishingRepo.findById(id).isPresent()){

        }
        throw new NotFoundException("Издательство не существует");
    }

    public void deletePublishingById(Long id){
        publishingRepo.deleteById(id);
    }
}
