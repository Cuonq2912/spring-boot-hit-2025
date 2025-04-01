package org.example.btvnbuoi4.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Entity
@Builder
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "dateofbirth", nullable = false)
    Date dateOfBirth;

    @Column(name = "gender", nullable = false)
    Gender gender;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "phonenumber", nullable = false, unique = true, length = 10)
    String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    Classes classes;
}
