package com.example.week22.controller;

import com.example.week22.model.Department;
import com.example.week22.model.ResponseObject;
import com.example.week22.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping(path = "department")
public class DepartmentController {
    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "createDepartments")
    public ResponseEntity<ResponseObject> autoCreateDepartments() {
        return departmentService.autoCreateDepartments();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseObject> updateDepartment(@RequestBody Department newDepartment,
                                                           @PathVariable String id) {
        return departmentService.updateDepartment(newDepartment, id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> deleteEmployee(@PathVariable String id) {
        return departmentService.deleteDepartmentById(id);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        return departmentService.findById(id);

    }

    @GetMapping("findV2/{id}")
    public ResponseEntity<ResponseObject> findByIdV2(@PathVariable String id) {
        return departmentService.findByIdV2(id);
    }

}
