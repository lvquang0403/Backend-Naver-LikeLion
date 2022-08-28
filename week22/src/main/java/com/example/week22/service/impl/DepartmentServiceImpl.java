package com.example.week22.service.impl;
import com.example.week22.model.Department;
import com.example.week22.model.ResponseObject;
import com.example.week22.model.dto.DepartmentDTO;
import com.example.week22.repository.DepartmentRepository;
import com.example.week22.repository.MbtRepository;
import com.example.week22.service.DepartmentService;
import com.example.week22.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;
    private final MbtRepository mbtRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeService employeeService, MbtRepository mbtRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeService = employeeService;
        this.mbtRepository = mbtRepository;
    }

    @Override
    public ResponseEntity<ResponseObject> autoCreateDepartments() {
        List<Department> departments = Arrays.asList(
                new Department("ROO1", "Marketing", "Marketing"),
                new Department("ROO2", "IT", "IT"),
                new Department("ROO3", "Director", "Director")
        );
        departments.forEach(departmentRepository::save);
        return ResponseEntity.ok().body(new ResponseObject("ok",
                "data about department inserted",
                departments
        ));
    }

    @Override
    public ResponseEntity<ResponseObject> updateDepartment(Department newDepartment, String id) {
        Department updateDepartment = departmentRepository.findById(id)
                .map(department -> {
                    department.setDepartmentId(newDepartment.getDepartmentId());
                    department.setDept_name(newDepartment.getDept_name());
                    department.setDescription(newDepartment.getDescription());
                    department.setEmployees(newDepartment.getEmployees());
                    return departmentRepository.save(department);
                }).orElseGet(()->{
                    newDepartment.setDepartmentId(id);
                    return departmentRepository.save(newDepartment);
                });
        return ResponseEntity.ok().body(
                new ResponseObject("ok", "update successfully", updateDepartment)
        );

    }

    @Override
    public ResponseEntity<ResponseObject> deleteDepartmentById(String id) {
        boolean exists = departmentRepository.existsById(id);
        if (exists){
            employeeService.deleteByDepartmentId(id);
            departmentRepository.deleteById(id);
            return ResponseEntity.ok().body(new ResponseObject(
                    "ok",
                    "delete successfully",
                    ""
            ));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                    "fail",
                    "departmentId not exists",
                    ""
            ));
        }
    }

    @Override
    public ResponseEntity<ResponseObject> findById(String id) {
        Optional<Department> foundDepartment = departmentRepository.findById(id);
        return foundDepartment.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                        "ok", "successfully",foundDepartment)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                        "fail", "not found", "")
                );

    }

    @Override
    public ResponseEntity<ResponseObject> findByIdV2(String id) {
        Optional<DepartmentDTO> foundDepartment = Optional.ofNullable(mbtRepository.findDepartmentById(id));
        return foundDepartment.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                        "ok", "successfully",foundDepartment)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                        "fail", "not found", "")
                );
    }


}
