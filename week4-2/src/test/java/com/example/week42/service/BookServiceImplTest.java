package com.example.week42.service;

import com.example.week42.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookServiceImpl bookService;

//    BookServiceImplTest(BookRepository bookRepository, BookServiceImpl bookService) {
//        this.bookRepository = bookRepository;
//        this.bookService = bookService;
//    }

    @Test
    void list(){
        bookService.list();
        verify(bookRepository).findAll();
    }
}