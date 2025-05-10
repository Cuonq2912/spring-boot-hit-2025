package org.example.test.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "authors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 60, nullable = false, unique = true)
    String name;

    @Column(name = "dateOfBirth", nullable = false)
    LocalDateTime dateOfBirth;

    @Column(columnDefinition = "TEXT")
    String bio;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    List<Book> bookList = new ArrayList<>();
}
