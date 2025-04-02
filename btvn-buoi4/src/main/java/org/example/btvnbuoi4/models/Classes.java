package org.example.btvnbuoi4.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "classes")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "subject", nullable = false)
    String subject;

    @OneToMany(mappedBy = "classes", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    List<Students> students = new ArrayList<>();
}
