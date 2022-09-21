package com.example.week2.service;

import com.example.week2.model.Employee;
import com.example.week2.model.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<ResponseObject> insertEmployee(Employee employee);
    ResponseEntity<ResponseObject> updateEmployee(Employee newEmployee, Long id);
    ResponseEntity<ResponseObject> deleteEmployee(Long id);
    ResponseEntity<ResponseObject> findAll();
    ResponseEntity<ResponseObject> deleteByDepartmentId(String id);

}
