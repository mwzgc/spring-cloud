package com.mwz.es.repository;

import com.mwz.es.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mawenzhong
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    /**
     * findById
     * @param id
     * @return
     */
    Book findById(String id);


    /**
     * findByAuthor
     * @param author
     * @param pageable
     * @return
     */
    Page<Book> findByAuthor(String author, Pageable pageable);


    /**
     * findByTitle
     * @param title
     * @param pageable
     * @return
     */
    Page<Book> findByTitle(String title, Pageable pageable);

}