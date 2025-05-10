package org.example.test.domain.mapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.test.domain.entity.Author;
import org.example.test.domain.entity.Category;
import org.example.test.repository.AuthorRepository;
import org.example.test.repository.CategoryRepository;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookMapperHelper {

    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;

    @Named("mapAuthor")
    public Author mapAuthor(Long id) {
        return id == null ? null : authorRepository.findById(id).orElse(null);
    }

    @Named("mapCategory")
    public Category mapCategory(Long id) {
        return id == null ? null : categoryRepository.findById(id).orElse(null);
    }


}
