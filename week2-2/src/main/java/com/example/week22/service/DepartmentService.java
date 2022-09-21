package com.example.week22.service;
import com.example.week22.model.Department;
import com.example.week22.model.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<ResponseObject> autoCreateDepartments();
    ResponseEntity<ResponseObject> updateDepartment(Department newDepartment, String id);
    ResponseEntity<ResponseObject> deleteDepartmentById(String id);
    ResponseEntity<ResponseObject> findById(String id);
    ResponseEntity<ResponseObject> findByIdV2(String id);
}
