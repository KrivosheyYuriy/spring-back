package com.example.back.dto.Author;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Data
public class AuthorDto {
    private Long id;

    @Pattern(regexp = "^[А-ЯЁа-яё]+$", message = "Неверный формат фамилии")
    private String surname;

    @Pattern(regexp = "^[А-ЯЁа-яё]+$", message = "Неверный формат имени")
    @NotBlank(message = "имя не должно быть пустым")
    private String name;

    @Pattern(regexp = "^[А-ЯЁа-яё]*$", message = "Invalid firstname format")
    private String fatherName;

    private String description;
}
