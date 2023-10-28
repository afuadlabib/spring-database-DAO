package com.fuad.database.dao;

import com.fuad.database.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> findAll();

    void update(String isbn, Book book);
    void delete(String isbn);
}
