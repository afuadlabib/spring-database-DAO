package com.fuad.database.dao.impl;

import com.fuad.database.dao.BookDao;
import com.fuad.database.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books(id, name, age) VALUE(? ,? ,?)",
                book.getIsbn(),
                book.getTitle(),
                book.getAuthorId()
        );
    }
}
