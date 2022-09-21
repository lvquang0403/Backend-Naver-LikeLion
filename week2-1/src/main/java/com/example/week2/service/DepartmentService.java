package com.example.week2.service;

import com.example.week2.model.Department;
import com.example.week2.model.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface DepartmentService {
    ResponseEntity<ResponseObject> autoCreateDepartments();
    ResponseEntity<ResponseObject> updateDepartment(Department newDepartment, String id);
    ResponseEntity<ResponseObject> deleteDepartmentById(String id);
    ResponseEntity<ResponseObject> findById(String id);
}
