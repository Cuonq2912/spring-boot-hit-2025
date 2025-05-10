package org.example.test.domain.mapper;

import org.example.test.domain.dto.BookCreateDto;
import org.example.test.domain.dto.BookDto;
import org.example.test.domain.dto.BookUpdateDto;
import org.example.test.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = BookMapperHelper.class)
public interface BookMapper {

    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategory")
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    Book toBook(BookCreateDto bookDto);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "authorId", source = "author.id")
    BookDto toBookDto(Book book);

    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategory")
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    void updateBookFromDto(BookUpdateDto bookDto, @MappingTarget Book book);
}
