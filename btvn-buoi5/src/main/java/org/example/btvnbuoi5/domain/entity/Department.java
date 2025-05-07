package org.example.btvnbuoi5.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 100, nullable = false, unique = true)
    String name;
    @Column(columnDefinition = "TEXT")
    String description;
    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    List<Employee> employees = new ArrayList<>();

}
