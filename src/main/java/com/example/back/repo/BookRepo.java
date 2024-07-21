package com.example.back.repo;

import com.example.back.models.Author;
import com.example.back.models.Book;
import com.example.back.models.Publishing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByEditor(String editor);
    List<Book> findByYearOfPublication(int yearOfPublication);
    List<Book> findByPublishing(Publishing publishing);
    List<Book> findBooksByAuthorsId(Long bookId);
    List<Book> findBooksByPublishingId(Long publishingId);
    List<Book> findBooksByGenresId(Long genreId);
    Book findByISBN(String ISBN);
}
