package org.example.test.service.work;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.test.constant.CommonConstant;
import org.example.test.constant.CommonMessage;
import org.example.test.constant.ErrorMessage;
import org.example.test.domain.dto.AuthorCreateDto;
import org.example.test.domain.dto.AuthorDto;
import org.example.test.domain.dto.AuthorUpdateDto;
import org.example.test.domain.dto.response.CommonResponseDto;
import org.example.test.domain.entity.Author;
import org.example.test.domain.mapper.AuthorMapper;
import org.example.test.exception.NotFoundException;
import org.example.test.repository.AuthorRepository;
import org.example.test.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorWork implements AuthorService {

    AuthorRepository authorRepository;
    AuthorMapper authorMapper;


    @Override
    public List<AuthorDto> getAllAuthor() {
        return authorRepository.findAll().stream().map(authorMapper::toAuthorDto).toList();
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        checkAuthorNotFound(author, id);
        return authorMapper.toAuthorDto(author.get());
    }

    @Override
    public AuthorDto createAuthor(AuthorCreateDto authorDto) {
        Author author = authorMapper.toAuthor(authorDto);
        return authorMapper.toAuthorDto(authorRepository.save(author));
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorUpdateDto authorDto) {
        Optional<Author> author = authorRepository.findById(id);
        checkAuthorNotFound(author, id);
        authorMapper.updateAuthorFromDto(authorDto, author.get());
        return authorMapper.toAuthorDto(authorRepository.save(author.get()));
    }

    @Override
    public CommonResponseDto deleteAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        checkAuthorNotFound(author, id);
        authorRepository.delete(author.get());
        return new CommonResponseDto(CommonConstant.TRUE, CommonMessage.DELETE_SUCCESS);
    }

    private void checkAuthorNotFound(Optional<Author> user, Long id) {
        if(user.isEmpty()){
            throw new NotFoundException(String.format(ErrorMessage.Author.ERR_NOT_FOUND_ID, id));
        }
    }
}
