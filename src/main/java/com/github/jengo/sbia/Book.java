package com.github.jengo.sbia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * {@link Book} 定义领域模型
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;
    @Getter @Setter private String reader;
    @Getter @Setter private String isbn;
    @Getter @Setter private String title;
    @Getter @Setter private String author;
    @Getter @Setter private String description;

}
