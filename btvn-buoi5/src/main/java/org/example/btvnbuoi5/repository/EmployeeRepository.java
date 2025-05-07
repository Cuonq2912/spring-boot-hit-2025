package org.example.btvnbuoi5.repository;

import org.example.btvnbuoi5.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.fullname like %:fullname%")
    List<Employee> findByFullname(String fullname);
    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByPositionId(Long posisionId);

    @Query("SELECT e FROM Employee e WHERE (:fullname IS NULL OR e.fullname LIKE %:fullname%) " +
            "AND (:departmentId IS NULL OR e.department.id = :departmentId) " +
            "AND (:positionId IS NULL OR e.position.id = :positionId)")
    List<Employee> findByMultipleCondition(
            @Param("fullname") String fullname,
            @Param("departmentId") Long departmentId,
            @Param("positionId") Long positionId);
}
