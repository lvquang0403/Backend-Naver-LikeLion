package com.example.springaop.dto;

import com.example.springaop.validator.EmployeesConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDTO {
    private Integer departmentId;
    @NotEmpty(message = "department name field not allowed empty")
    @Size(min = 10, max = 50, message = "number character limit between 10 and 50")
    private String deptName;
    @NotEmpty(message = "description field not allowed empty")
    private String description;
    @Valid
    private List<EmployeeDTO> listEmployee;
}
