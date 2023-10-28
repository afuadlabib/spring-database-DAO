package com.fuad.database.dao.impl;

import com.fuad.database.TestDataUtil;
import com.fuad.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("978-1-2345-6789-5"),
                eq("The Shadow in the Attic A"),
                eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesCorrectSql() {
        underTest.findOne("978-1-2345-6789-0");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("978-1-2345-6789-0")
        );
    }
    @Test
    public void testThatFindAllBookGeneratesCorrectSql(){
        underTest.findAll();

        verify(jdbcTemplate).query(
                eq("SELECT * FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }
    @Test
    public void testThatUpdateGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.update("978-1-2345-6789-5", book);
        verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                "978-1-2345-6789-5", "The Shadow in the Attic A", 1L, "978-1-2345-6789-5"
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql() {
        underTest.delete("978-1-2345-6789-0");
        verify(jdbcTemplate).update(
                "DELETE FROM books where isbn = ?",
                "978-1-2345-6789-0"
        );
    }

}
