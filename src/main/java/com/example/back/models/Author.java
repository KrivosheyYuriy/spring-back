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
@Entity
@Table(name = "Authors")
@AllArgsConstructor // аннотация означает наличие конструктора со всеми аргументами
@NoArgsConstructor // аннотация означает наличие конструктора без аргументов
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = true)
    private String fatherName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "AuthorBook",
            joinColumns = {@JoinColumn(name = "authorId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "id")})
    private Set<Book> books = new HashSet<>();

    @Column(nullable = true)
    private String description;

}
