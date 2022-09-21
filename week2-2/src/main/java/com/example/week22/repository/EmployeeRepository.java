package com.example.week22.repository;
import com.example.week22.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    @Modifying
    @Query(value = "DELETE FROM Employee WHERE departmentId=?1")
    void deleteEmployeeByDepartment(String departmentId);
}
