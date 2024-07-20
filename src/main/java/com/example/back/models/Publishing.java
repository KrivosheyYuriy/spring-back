package com.example.back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "Publishings")
@NoArgsConstructor
@AllArgsConstructor
public class Publishing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "publishing")
    private Book book;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = true)
    private String description;

    @Column(unique = true, nullable = true)
    private String phone;

    @Column(unique = true, nullable = true)
    private String email;
}
