package com.weCode.bookStore;

import java.util.List;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.repository.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@SpringBootTest(classes = SpringBootApplication.class)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts={"classpath:initalSQLToInsertDataForTests.sql"})
    void shouldAbletoRetrieveAllBooksInDB(){
        Iterable<Book> findAll = bookRepository.findAll();
        Long totalCount = StreamSupport.stream(findAll.spliterator(),false).count();
        Assertions.assertEquals(2, totalCount);
    }

    @Test
    @Sql(scripts={"classpath:initalSQLToInsertDataForTests.sql"})
    void shouldReturnOneBookWhenTitleisTestBookTitle(){
        List<Book> test_title = bookRepository.findBooksByTitle("Test Book");
        Assertions.assertEquals(test_title.size(), 1);
    }
}
