package org.example.test.repository;

import org.example.test.domain.entity.Book;
import org.example.test.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
