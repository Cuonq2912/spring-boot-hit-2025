package org.example.test.domain.mapper;

import org.example.test.domain.dto.AuthorCreateDto;
import org.example.test.domain.dto.AuthorDto;
import org.example.test.domain.dto.AuthorUpdateDto;
import org.example.test.domain.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(AuthorCreateDto authorDto);
    AuthorDto toAuthorDto(Author author);
    void updateAuthorFromDto(AuthorUpdateDto authorDto, @MappingTarget Author author);
}
