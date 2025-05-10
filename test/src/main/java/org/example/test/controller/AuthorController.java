package org.example.test.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.test.base.RestApiV1;
import org.example.test.base.VsResponseUtil;
import org.example.test.constant.UrlConstant;
import org.example.test.domain.dto.AuthorCreateDto;
import org.example.test.domain.dto.AuthorUpdateDto;
import org.example.test.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestApiV1
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController {

    AuthorService authorService;

    @GetMapping(UrlConstant.Author.GET_AUTHORS)
    public ResponseEntity<?> getAllAuthor(){
        return VsResponseUtil.ok(authorService.getAllAuthor());
    }

    @GetMapping(UrlConstant.Author.CREATE_AUTHOR)
    public ResponseEntity<?> createAuthor(@Valid @RequestBody AuthorCreateDto authorCreateDto){
        return VsResponseUtil.ok(authorService.createAuthor(authorCreateDto));
    }

    @GetMapping(UrlConstant.Author.GET_AUTHOR)
    public ResponseEntity<?> getAuthorById(@PathVariable Long authorId){
        return VsResponseUtil.ok(authorService.getAuthorById(authorId));
    }


    @PutMapping(UrlConstant.Author.UPDATE_AUTHOR)
    public ResponseEntity<?> updateUser(@Valid @RequestBody AuthorUpdateDto authorUpdateDto, @PathVariable Long authorId) {
        return VsResponseUtil.ok(authorService.updateAuthor(authorId, authorUpdateDto));
    }

    @DeleteMapping(UrlConstant.Author.DELETE_AUTHOR)
    public ResponseEntity<?> deleteUser(@PathVariable Long authorId) {
        return VsResponseUtil.ok(authorService.deleteAuthor(authorId));
    }
}
