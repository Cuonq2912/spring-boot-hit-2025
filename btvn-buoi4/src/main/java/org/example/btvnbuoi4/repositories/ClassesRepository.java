package org.example.btvnbuoi4.repositories;

import org.example.btvnbuoi4.models.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    boolean existsByName(String name);
}
