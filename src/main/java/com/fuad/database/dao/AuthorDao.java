package com.fuad.database.dao;

import com.fuad.database.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long authorId);

    List<Author> findAll();

    void update(long id, Author author);

    void delete(long id);
}
