package com.example.back.convertor;

import com.example.back.dto.Author.AuthorDto;
import com.example.back.models.Author;

import java.util.HashSet;

public class AuthorMapper {
    public static AuthorDto mapToAuthorDto(Author author) {
        return new AuthorDto(author.getId(),
                author.getSurname(),
                author.getName(),
                author.getFatherName(),
                author.getDescription());
    }

    public static Author mapToAuthor(AuthorDto authorDto) {
        return new Author(authorDto.getId(),
                authorDto.getSurname(),
                authorDto.getName(),
                authorDto.getFatherName(),
                new HashSet<>(),
                authorDto.getDescription());
    }
}
