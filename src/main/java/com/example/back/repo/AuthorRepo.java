package com.example.back.repo;

import com.example.back.models.Author;
import com.example.back.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // показывает, что перехватывает исключения при ошибке действия с данными БД
public interface AuthorRepo extends CrudRepository<Author, Long> {
    List<Author> findByNameContainingIgnoreCase(String name);
    List<Author> findBySurnameContainingIgnoreCase(String surname);
    List<Author> findByFatherNameContainingIgnoreCase(String fatherName);

    List<Author> findBySurnameContainingIgnoreCaseAndNameContainingIgnoreCase
            (String surname, String name);

    List<Author> findByNameContainingIgnoreCaseAndFatherNameContainingIgnoreCase
            (String name, String fatherName);

    List<Author> findBySurnameContainingIgnoreCaseAndFatherNameContainingIgnoreCase
            (String surname, String fatherName);

    List<Author> findBySurnameIgnoreCaseAndNameIgnoreCaseAndFatherNameIgnoreCase
            (String surname, String name, String fatherName);

    List<Author> findAuthorsByBooksId(Long bookId);

}
