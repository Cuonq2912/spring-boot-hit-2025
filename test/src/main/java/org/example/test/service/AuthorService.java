package org.example.test.service;

import org.example.test.domain.dto.AuthorCreateDto;
import org.example.test.domain.dto.AuthorDto;
import org.example.test.domain.dto.AuthorUpdateDto;
import org.example.test.domain.dto.response.CommonResponseDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthor();
    AuthorDto getAuthorById(Long id);
    AuthorDto createAuthor(AuthorCreateDto authorDto);
    AuthorDto updateAuthor(Long id, AuthorUpdateDto authorDto);
    CommonResponseDto deleteAuthor(Long id);
}
