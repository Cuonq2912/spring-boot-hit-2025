package org.example.btvnbuoi5.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    Department department;
    @ManyToOne
    @JoinColumn(name = "position_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    Position position;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    User user;

    @Column(name = "full_name", length = 100, nullable = false)
    String fullName;
    @Column(name = "date_of_birth", columnDefinition = "DATE")
    LocalDate dateOfBirth;
    @Column(name = "hired_date", columnDefinition = "DATE")
    LocalDate hiredDate;
    @Column(precision = 10, scale = 2)
    BigDecimal salary;
}
