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
@Table(name = "Books") // в виде отдельной таблицы
@AllArgsConstructor // аннотация означает наличие конструктора со всеми аргументами
@NoArgsConstructor // аннотация означает наличие конструктора без аргументов
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "publishingId", referencedColumnName = "id")
    private Publishing publishing;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "BookGenre",
            joinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genreId", referencedColumnName = "id")})
    private Set<Genre> genres = new HashSet<>();

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String editor;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private Integer yearOfPublication;

    @Column(unique = true)
    private String ISBN;

}