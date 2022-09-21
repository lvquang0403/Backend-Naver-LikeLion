package com.example.week42.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
//    @Autowired
//    BookRepositoryTest(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }


    @AfterEach
    void tearDown(){
        bookRepository.deleteAll();
    }

    @Test
    void getListBook(){
        assertThat("This is my simple Test").isNotNull()
                .startsWith("This");
    }

}
