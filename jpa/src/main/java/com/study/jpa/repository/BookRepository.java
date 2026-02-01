package com.study.jpa.repository;

import com.study.jpa.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Page<Book> findBooksByGenre(String genre, Pageable pageable);
    Page<Book> findBooksByTitle(String genre, Pageable pageable);
}
