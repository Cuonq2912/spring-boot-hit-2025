package org.example.btvnonline1.domain.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "hotels")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hotel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String location;

    Double price;

    LocalDateTime createdDate;

    LocalDateTime lastModifiedDate;

}
