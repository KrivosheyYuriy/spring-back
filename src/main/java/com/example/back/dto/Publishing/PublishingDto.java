package com.example.back.dto.Publishing;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Data
@Getter
@Setter
public class PublishingDto {
    private Long id;

    @Pattern(regexp = "^[А-ЯЁа-яё]+$", message = "Неверный формат имени")
    @NotBlank(message = "Название издательства не должно быть пустым")
    private String title;

    @Email
    private String email;

    @Pattern(regexp = "(\\+7|8)([0-9]{10})")
    private String phone;

    private String description;
}
