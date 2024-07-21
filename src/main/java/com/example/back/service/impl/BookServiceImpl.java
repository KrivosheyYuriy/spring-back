package com.example.back.service.impl;

import com.example.back.dto.Book.BookDto;
import com.example.back.models.Book;
import com.example.back.repo.BookRepo;
import com.example.back.domain.exception.NotFoundException;
import com.example.back.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
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

    public Book updateBook(Long id, BookDto book) {
        Book bookDB = getBookById(id);
        bookDB.setTitle(book.getTitle());
        bookDB.setYearOfPublication(book.getYearOfPublication());
        bookDB.setEditor(book.getEditor());
        bookDB.setPages(book.getPages());
        bookDB.setDescription(book.getDescription());
        bookDB.setISBN(book.getISBN());
        return bookRepo.save(bookDB);
    }

    public Book deleteBookById(Long id) {
        if (bookRepo.findById(id).isPresent()){
            Book book = bookRepo.findById(id).get();
            bookRepo.delete(book);
            return book;
        }
        throw new NotFoundException("Книга не найдена!");
    }
}
