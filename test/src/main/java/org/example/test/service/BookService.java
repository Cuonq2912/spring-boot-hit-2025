package org.example.test.service;

import org.example.test.domain.dto.BookCreateDto;
import org.example.test.domain.dto.BookDto;
import org.example.test.domain.dto.BookUpdateDto;
import org.example.test.domain.dto.response.CommonResponseDto;

import java.util.List;


public interface BookService {

    BookDto getBookById(Long id);
    BookDto createBook(BookCreateDto bookDto);
    BookDto updateBook(Long id, BookUpdateDto bookDto);
    CommonResponseDto deleteBook(Long id);


//    List<BookDto> getBookByName(String name);


}
