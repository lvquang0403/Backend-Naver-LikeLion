package com.example.week42.service;

import com.example.week42.repository.BookRepository;

public class BookServiceImpl {
   private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void list(){
        bookRepository.findAll();
    }
}
