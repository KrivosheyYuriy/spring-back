package com.example.back.service.impl;

import com.example.back.domain.exception.NotFoundException;
import com.example.back.models.Genre;
import com.example.back.repo.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl {
    @Autowired
    GenreRepo genreRepo;

    public Genre addGenre(Genre genre){
        return genreRepo.save(genre);
    }

    public Genre updateGenre(Long id, Genre genre){
        Genre genreDB = getGenre(id);
        // обработка
        return genreRepo.save(genreDB);
    }

    public Genre getGenre(Long id){
        if (genreRepo.findById(id).isPresent()){
            return genreRepo.findById(id).get();
        }
        throw new NotFoundException("Жанр не найден");
    }

    public void deleteGenreById(Long id){
        genreRepo.deleteById(id);
    }

    public String GetGenreDescription(Long id){
        Genre genreDB = getGenre(id);
        return genreDB.getDescription();
    }
}
