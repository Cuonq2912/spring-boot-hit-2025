package org.example.btvnonline1.repository;

import org.example.btvnonline1.domain.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT h FROM Hotel h " +
            "WHERE (:name IS NULL OR h.name LIKE %:name%) " +
            "AND (:location IS NULL OR h.location LIKE %:location%) " +
            "AND (:price IS NULL OR h.price = :price)")
    Page<Hotel> searchHotels(@Param("name") String name,
                             @Param("location") String location,
                             @Param("price") Double price,
                             Pageable pageable);

}
