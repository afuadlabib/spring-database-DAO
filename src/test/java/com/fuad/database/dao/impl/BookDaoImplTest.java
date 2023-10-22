package com.fuad.database.dao.impl;

import com.fuad.database.dao.BookDao;
import com.fuad.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGenerateCorrectSql(){
        Book book = Book.builder()
                .isbn("1245-4542-4580")
                .title("test")
                .authorId(1L)
                .build();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books(id, name, age) VALUE(? ,? ,?)"),
                eq("1245-4542-4580"),
                eq("test"),
                eq(1L)
        );
    }
}
