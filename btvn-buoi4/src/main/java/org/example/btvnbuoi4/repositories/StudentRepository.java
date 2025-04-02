package org.example.btvnbuoi4.repositories;

import org.example.btvnbuoi4.dtos.responses.StudentResponse;
import org.example.btvnbuoi4.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    StudentResponse findByName(String name);
    List<StudentResponse> findByClasses_Name(String classes);
}
