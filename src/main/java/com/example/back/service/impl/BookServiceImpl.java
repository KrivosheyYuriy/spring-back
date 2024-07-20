package com.example.back.service.impl;

import com.example.back.models.Book;
import com.example.back.repo.BookRepo;
import com.example.back.domain.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl {
    @Autowired
    BookRepo bookRepo;

    public List<Book> getAllBooks(){
        return (List<Book>) bookRepo.findAll();
    }

    public Book getBookById(Long id){
        if (bookRepo.findById(id).isPresent()){
            return bookRepo.findById(id).get();
        }
        throw new NotFoundException("Книга не найдена");
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book bookDB = getBookById(id);
        bookDB.setTitle(book.getTitle());
        bookDB.setAuthors(book.getAuthors());
        bookDB.setPublishing(book.getPublishing());
        bookDB.setGenres(book.getGenres());
        bookDB.setYearOfPublication(book.getYearOfPublication());
        bookDB.setEditor(book.getEditor());
        bookDB.setPages(book.getPages());
        bookDB.setDescription(book.getDescription());
        bookDB.setISBN(book.getISBN());
        return bookRepo.save(bookDB);
    }

    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }
}
