package com.example.week22.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    private String departmentId;
    private String dept_name;
    private String description;

    public Department(String departmentId, String dept_name, String description, List<Employee> employees) {
        this.departmentId = departmentId;
        this.dept_name = dept_name;
        this.description = description;
        this.employees = employees;
    }

    public Department(String departmentId, String dept_name, String description) {
        this.departmentId = departmentId;
        this.dept_name = dept_name;
        this.description = description;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<Employee> employees;


}
