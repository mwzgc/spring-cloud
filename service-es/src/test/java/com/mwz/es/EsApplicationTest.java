package com.mwz.es;

import com.alibaba.fastjson.JSON;
import com.mwz.es.entity.Book;
import com.mwz.es.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Slf4j
@SpringBootTest
public class EsApplicationTest {

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void save() {
        bookRepository.save(new Book().setId(1).setAuthor("auth").setBookName("book"));
    }

    @Test
    public void query() {
        Page<Book> page = bookRepository.findByTitle("b", Pageable.unpaged());
        log.info("page = {}", JSON.toJSONString(page));
    }


}