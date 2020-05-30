package com.mwz.es.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author mawenzhong
 */

@Data
@ToString
@Accessors(chain = true)
@Document( indexName = "library" , type = "book")
public class Book {

    @Id
    private Integer id;

    private String title;

    private String bookName;

    private String author;

}
