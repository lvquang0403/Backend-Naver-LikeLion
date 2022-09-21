package com.example.week2.model;

import com.example.week2.model.Department;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String name;
    private Date birthDate;
    private Boolean gender;
    private String departmentId;
}
