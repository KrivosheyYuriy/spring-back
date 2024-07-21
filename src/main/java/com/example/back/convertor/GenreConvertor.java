package com.example.back.convertor;

import com.example.back.dto.Genre.GenreDto;
import com.example.back.models.Genre;

public class GenreConvertor {
    public static GenreDto mapToGenreDto(Genre genre){
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        genreDto.setDescription(genre.getDescription());
        return genreDto;
    }

    public static Genre mapToGenre(GenreDto genreDto){
        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setName(genreDto.getName());
        genre.setDescription(genreDto.getDescription());
        return genre;
    }
}
