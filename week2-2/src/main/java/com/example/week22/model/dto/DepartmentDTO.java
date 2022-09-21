package com.example.week22.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String departmentId;
    private String dept_name;
    private String description;
    private Integer numEmployee;
}
