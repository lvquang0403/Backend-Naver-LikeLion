package com.example.week2.service.impl;

import com.example.week2.model.Department;
import com.example.week2.model.Employee;
import com.example.week2.model.ResponseObject;
import com.example.week2.model.EmployeeDTO;
import com.example.week2.repository.DepartmentRepository;
import com.example.week2.repository.EmployeeRepository;
import com.example.week2.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<ResponseObject> insertEmployee(Employee employee) {
        try{
            if(departmentRepository.findById(employee.getDepartmentId()).isPresent()){
                Department departmentOfEmployee = departmentRepository.findById(employee.getDepartmentId()).orElse(null);
                Employee newEmployee = new Employee(
                        employee.getName(),
                        employee.getBirthDate(),
                        employee.getGender(),
                        employee.getDepartmentId(),
                        departmentOfEmployee
                );
                employeeRepository.save(newEmployee);
                EmployeeDTO employeeDTO = new EmployeeDTO(newEmployee.getEmployeeId(),
                        newEmployee.getName(),
                        newEmployee.getBirthDate(),
                        newEmployee.getGender(),
                        newEmployee.getDepartmentId());
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "create successfully",employeeDTO)
                );
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("fail","Id exits",null)
                );
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("fail","error",null)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateEmployee(Employee newEmployee, Long id) {
        Employee updateEmployee = employeeRepository.findById(id)
                .map(employee -> {
                    employee.setEmployeeId(newEmployee.getEmployeeId());
                    employee.setName(newEmployee.getName());
                    employee.setBirthDate(newEmployee.getBirthDate());
                    employee.setGender(newEmployee.getGender());
                    employee.setDepartmentId(newEmployee.getDepartmentId());
                    employee.setDepartment(newEmployee.getDepartment());
                    return employeeRepository.save(employee);
                }).orElseGet(()->{
                    newEmployee.setEmployeeId(id);
                    return employeeRepository.save(newEmployee);
                });
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "update successfully", updateEmployee)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> deleteEmployee(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if (exists){
            employeeRepository.deleteById(id);
            return ResponseEntity.ok().body(new ResponseObject(
                    "ok",
                    "delete successfully",
                    ""
            ));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                    "fail",
                    "employeeId not exists",
                    ""
            ));
        }
    }

    @Override
    public ResponseEntity<ResponseObject> findAll() {
        List<Employee> employees = employeeRepository.findAll();

        employees.stream()
                .map(employee -> {
                    return new EmployeeDTO(employee.getEmployeeId(),
                            employee.getName(),
                            employee.getBirthDate(),
                            employee.getGender(),
                            employee.getDepartmentId());
                });
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "ok",
                "successfully",
                employees
        ));
    }
    @Override
    @Transactional
    public ResponseEntity<ResponseObject> deleteByDepartmentId(String id){
        employeeRepository.deleteEmployeeByDepartment(id);
        return ResponseEntity.ok().body(new ResponseObject("ok","delete successfully",""));
    }
}
