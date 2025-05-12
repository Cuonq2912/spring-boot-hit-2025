package org.example.test.repository;

import org.example.test.domain.dto.BookDto;
import org.example.test.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b " +
            "WHERE (:name IS NULL OR b.name LIKE %:name%) " +
            "AND (:price IS NULL OR b.price = :price) " +
            "AND (:authorName IS NULL OR b.author.name LIKE %:authorName%) " +
            "AND (:categoryName IS NULL OR b.category.name LIKE %:categoryName%)" )
    List<Book> getBookByMultiCondition(
            @Param("name") String name,
            @Param("price") Double price,
            @Param("authorName") String authorName,
            @Param("categoryName") String categoryName
    );

}
