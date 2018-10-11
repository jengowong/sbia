package com.github.jengo.sbia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * {@link ReadingListRepository} 定义仓库接口
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
