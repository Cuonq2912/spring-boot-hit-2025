package org.example.test.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.test.base.RestApiV1;
import org.example.test.base.VsResponseUtil;
import org.example.test.constant.UrlConstant;
import org.example.test.domain.dto.BookCreateDto;
import org.example.test.domain.dto.BookUpdateDto;
import org.example.test.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {

    BookService bookService;

    @GetMapping(UrlConstant.Book.GET_BOOK)
    public ResponseEntity<?> getBookById(@PathVariable Long bookId){
        return VsResponseUtil.ok(bookService.getBookById(bookId));
    }

    @GetMapping(UrlConstant.Book.GET_BOOKS + "/search")
    public ResponseEntity<?> getBookByMultipleCondition(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) String categoryName
            ){
        return VsResponseUtil.ok(bookService.findByMultipleCondition(
                name, price, authorName, categoryName
        ));
    }

    @PostMapping(UrlConstant.Book.CREATE_BOOK)
    public ResponseEntity<?> createBook(@Valid @RequestBody BookCreateDto bookCreateDto) {
        return VsResponseUtil.ok(bookService.createBook(bookCreateDto));
    }

    @PutMapping(UrlConstant.Book.UPDATE_BOOK)
    public ResponseEntity<?> updateBook(@Valid @RequestBody BookUpdateDto bookUpdateDto, @PathVariable Long bookId) {
        return VsResponseUtil.ok(bookService.updateBook(bookId, bookUpdateDto));
    }

    @DeleteMapping(UrlConstant.Book.DELETE_BOOK)
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        return VsResponseUtil.ok(bookService.deleteBook(bookId));
    }



}
