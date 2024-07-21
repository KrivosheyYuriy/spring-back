package com.example.back.dto.Genre;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class GenreDto {
    private Long id;

    @Pattern(regexp = "^[А-ЯЁа-яё]+$", message = "Неверный формат имени")
    @NotBlank(message = "Название жанра не должно быть пустым")
    private String name;

    private String description;
}
