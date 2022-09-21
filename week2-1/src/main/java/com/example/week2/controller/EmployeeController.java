package com.example.week2.controller;

import com.example.week2.model.Employee;
import com.example.week2.model.ResponseObject;
import com.example.week2.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "insert")
    public ResponseEntity<ResponseObject> insertEmployee(@RequestBody Employee employee){
        return employeeService.insertEmployee(employee);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody Employee newEmployee,
                                                         @PathVariable Long id){
        return employeeService.updateEmployee(newEmployee, id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("findAll")
    public ResponseEntity<ResponseObject> findAll(){
        return employeeService.findAll();
    }

}
