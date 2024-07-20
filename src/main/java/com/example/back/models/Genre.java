package com.example.back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter // аннотация означает наличие методов set
@Getter //  аннотация означает наличие методов get
@Entity // это сущность
@Table(name = "Genres")
@AllArgsConstructor // аннотация означает наличие конструктора со всеми аргументами
@NoArgsConstructor // аннотация означает наличие конструктора без аргументов
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "genres")
    private Set<Book> books = new HashSet<>();

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = true)
    private String description;

}