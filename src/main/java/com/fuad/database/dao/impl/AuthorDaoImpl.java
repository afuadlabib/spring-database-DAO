package com.fuad.database.dao.impl;

import com.fuad.database.dao.AuthorDao;
import com.fuad.database.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
                author.getId(),
                author.getName(),
                author.getAge()
        );
    }

    @Override
    public Optional<Author> findOne(long authorId) {
        List<Author> result = jdbcTemplate.query(
                "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
                new AuthorRowMapper(),
                authorId
        );
        return result.stream().findFirst();
    }

        public static class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException{
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
