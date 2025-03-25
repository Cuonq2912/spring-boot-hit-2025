package org.example.btvnbuoi3.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    String name;

    @Column(unique = true, length = 150)
    String email;

    @Column(name = "phone_number", length = 15)
    String phoneNumber;

    @Column(name = "home_address", columnDefinition ="TEXT")
    String address;
}
