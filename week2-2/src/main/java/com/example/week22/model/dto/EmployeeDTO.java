package com.example.week22.model.dto;

import com.example.week22.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private Date birthDate;
    private Boolean gender;
    private DepartmentDTO department;

    public EmployeeDTO(Long employeeId, String name, Date birthDate, Boolean gender, String departmentId) {
    }
}
