package com.example.back.dto.Genre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class GenreDto {
    private Long id;

    @Pattern(regexp = "^[А-ЯЁа-яё]+$", message = "Неверный формат имени")
    @NotBlank(message = "Название жанра не должно быть пустым")
    private String name;

    private String description;
}
