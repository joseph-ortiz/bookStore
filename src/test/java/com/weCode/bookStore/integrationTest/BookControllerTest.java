package com.weCode.bookStore.integrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import com.weCode.bookStore.BookStoreApplication;
import com.weCode.bookStore.dto.BookDTO;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BookStoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /* @Test
    @Sql("classpath:initalSQLToInsertDataForTests.sql")
    void shouldReturnBooksWhenBookApiCalled(){
        String url = "http://localhost:"+port+"/api/v1/books";
        BookDTO[] listOfBooks = testRestTemplate.getForObject(url, BookDTO[].class);
        assertThat(listOfBooks).isNotNull();
        assertThat(listOfBooks.length).isEqualTo(2);
    } */

    @Test
    @Sql("classpath:initalSQLToInsertDataForTests.sql")
    void shouldReturnBooksWhenBookApiCalled1(){
        String url = "http://localhost:"+port+"/api/v1/books";
        BookDTO[] listOfBooks = testRestTemplate.getForObject(url, BookDTO[].class);
        assertThat(listOfBooks).isNotNull();
        assertThat(listOfBooks.length).isEqualTo(2);
    }

}
