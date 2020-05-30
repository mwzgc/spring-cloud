package com.mwz.es;

import com.mwz.es.entity.Book;
import com.mwz.es.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class EsApplicationTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void save() {
        bookRepository.save(new Book().setId(1).setAuthor("auth").setBookName("book"));
    }

}