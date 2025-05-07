package org.example.btvnbuoi5.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 60, nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    String password;
    @Column(length = 100, nullable = false, unique = true)
    String email;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    LocalDateTime createAt;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    List<Employee> employees = new ArrayList<>();

}
