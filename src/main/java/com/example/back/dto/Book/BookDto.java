package com.example.back.dto.Book;

import com.example.back.dto.Publishing.PublishingDto;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;

    @NotBlank(message = "У книги дожно быть название")
    private String title;

    @Pattern(regexp = "^[А-ЯЁа-яё\\a]+$", message = "Неверный формат редактора")
    private String editor;

    private String description;

    @Min(value = 1, message = "Некорретное количество страниц")
    @NotBlank(message = "Не указано количество страниц")
    private Integer pages;
    @Min(value = 1960, message = "Некорректный год издания")
    @NotBlank(message = "Не указан год издания")
    private Integer yearOfPublication;

    @NotBlank(message = "Не указан ISBN")
    @Pattern(regexp = "[\\-0-9]+", message = "Некорретный формат ISBN")
    private String ISBN;
}
