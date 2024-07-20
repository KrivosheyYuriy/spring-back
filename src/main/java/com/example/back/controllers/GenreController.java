package com.example.back.controllers;

import com.example.back.models.Genre;
import com.example.back.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    private GenreServiceImpl genreService;

    @PostMapping("")
    public Genre createGenre(@RequestBody Genre genre){
        return genreService.addGenre(genre);
    }

    @PostMapping("/{genreId}/{bookId}")
    public void addBookToGenre(@PathVariable Long genreId, @PathVariable Long bookId){

    }

    @DeleteMapping("/{genreId}/{bookId}")
    public void deleteBookFromGenre(@PathVariable Long genreId, @PathVariable Long bookId){

    }

    @PutMapping("/{genreId}")
    public Genre updateGenre(@PathVariable Long genreId, @RequestBody Genre genre){
        return genreService.updateGenre(genreId, genre);
    }

    @GetMapping("/{genreId}")
    public String getGenreInfo(@PathVariable Long genreId){
        return genreService.GetGenreDescription(genreId);
    }

    @GetMapping("/books")
    public void getAllGenreBooks(){

    }

}
