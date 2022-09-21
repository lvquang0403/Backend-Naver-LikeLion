package com.example.week2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;
    private Boolean gender;
    @Column(name="department_id")
    private String departmentId;

    public Employee(String name, Date birthDate, Boolean gender, String departmentId, Department department) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.departmentId = departmentId;
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "department")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Department department;

}
