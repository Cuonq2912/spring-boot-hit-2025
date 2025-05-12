package org.example.test.service.work;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.test.constant.CommonConstant;
import org.example.test.constant.CommonMessage;
import org.example.test.constant.ErrorMessage;
import org.example.test.domain.dto.BookCreateDto;
import org.example.test.domain.dto.BookDto;
import org.example.test.domain.dto.BookUpdateDto;
import org.example.test.domain.dto.response.CommonResponseDto;
import org.example.test.domain.entity.Book;
import org.example.test.domain.mapper.BookMapper;
import org.example.test.exception.NotFoundException;
import org.example.test.repository.BookRepository;
import org.example.test.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookWork implements BookService {

    BookRepository bookRepository;
    BookMapper bookMapper;

    @Override
    public BookDto getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        checkBookNotFound(book, id);
        return bookMapper.toBookDto(book.get());
    }

    @Override
    public BookDto createBook(BookCreateDto bookDto) {
        Book book = bookMapper.toBook(bookDto);
        return bookMapper.toBookDto(bookRepository.save(book));
    }

    @Override
    public BookDto updateBook(Long id, BookUpdateDto bookDto) {
        Optional<Book> book = bookRepository.findById(id);
        checkBookNotFound(book, id);
        bookMapper.updateBookFromDto(bookDto, book.get());
        return bookMapper.toBookDto(bookRepository.save(book.get()));
    }

    @Override
    public CommonResponseDto deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        checkBookNotFound(book, id);
        bookRepository.deleteById(id);
        return new CommonResponseDto(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }

    @Override
    public List<BookDto> findByMultipleCondition(String name, Double price, String authorName, String categoryName) {
        List<Book> books = bookRepository.getBookByMultiCondition(name, price, authorName, categoryName);
        if (books.isEmpty()) {
            throw new NotFoundException(ErrorMessage.Book.ERR_NOT_FOUND);
        }
        return bookMapper.toBookDtoList(books);
    }


    private void checkBookNotFound(Optional<Book> book, Long id){
        if(book.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Book.ERR_NOT_FOUND_ID, id));
        }
    }
}
