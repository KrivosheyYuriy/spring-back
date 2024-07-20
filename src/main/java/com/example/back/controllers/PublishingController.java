package com.example.back.controllers;

import com.example.back.service.impl.PublishingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublishingController {
    @Autowired
    private PublishingServiceImpl publishingService;



}
