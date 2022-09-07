package com.example.springaop.controller;

import com.example.springaop.dto.DepartmentDTO;
import com.example.springaop.dto.EmployeeDTO;
import com.example.springaop.exception.ArgumentNotValidException;
import com.example.springaop.response.ResponseObject;
import com.example.springaop.service.DepartmentDTOService;
import com.example.springaop.service.EmployeeDTOService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("")
@RestController
public class testApiController {
    private final DepartmentDTOService departmentDTOService;
    private final EmployeeDTOService employeeDTOService;

    public testApiController(DepartmentDTOService departmentDTOService, EmployeeDTOService employeeDTOService) {
        this.departmentDTOService = departmentDTOService;
        this.employeeDTOService = employeeDTOService;
    }

    @PostMapping("department")
    public ResponseEntity<ResponseObject> addDepartment(@RequestBody @Valid DepartmentDTO departmentDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ArgumentNotValidException(bindingResult);
        }
        departmentDTOService.getDepartmentDTO(departmentDTO);
        return ResponseEntity.ok().body(new ResponseObject(
                "ok",
                "Successfully",
                departmentDTO));
    }
    @PostMapping("employee")
    public ResponseEntity<Object> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ArgumentNotValidException(bindingResult);
        }
        employeeDTOService.getEmployeeDTO(employeeDTO);
        return ResponseEntity.ok().body(new ResponseObject(
                "ok",
                "Successfully",
                employeeDTO
        ));
    }


}
