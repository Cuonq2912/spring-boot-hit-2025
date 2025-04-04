package org.example.btvnbuoi4.repositories;

import org.example.btvnbuoi4.dtos.responses.StudentResponse;
import org.example.btvnbuoi4.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Students findByName(String name);
    @Query("SELECT s FROM Students s WHERE s.classes.name = :classesName")
    List<Students> findByClasses_Name(@Param("classesName")String classes);
}
