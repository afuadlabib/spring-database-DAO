package com.fuad.database;

import com.fuad.database.domain.Author;
import com.fuad.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("978-1-2345-6789-5")
                .title("The Shadow in the Attic A")
                .authorId(1L)
                .build();
    }
     public static Book createTestBookB() {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("The Shadow in the Attic B")
                .authorId(1L)
                .build();
    }
     public static Book createTestBookC() {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Shadow in the Attic C")
                .authorId(1L)
                .build();
    }

}
