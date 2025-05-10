package org.example.btvnbuoi5.repository;

import org.example.btvnbuoi5.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.fullName like %:fullName%")
    List<Employee> findByFullName(String fullName);
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByPositionId(Long positionId);

    @Query("SELECT e FROM Employee e WHERE (:fullName IS NULL OR e.fullName LIKE %:fullName%) " +
            "AND (:departmentId IS NULL OR e.department.id = :departmentId) " +
            "AND (:positionId IS NULL OR e.position.id = :positionId)")
    List<Employee> findByMultipleCondition(
            @Param("fullName") String fullName,
            @Param("departmentId") Long departmentId,
            @Param("positionId") Long positionId);
}
