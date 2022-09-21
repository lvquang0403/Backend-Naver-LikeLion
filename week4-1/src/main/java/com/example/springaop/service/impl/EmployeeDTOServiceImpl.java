package com.example.springaop.service.impl;

import com.example.springaop.dto.EmployeeDTO;
import com.example.springaop.service.EmployeeDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDTOServiceImpl implements EmployeeDTOService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDTOServiceImpl.class);

    public EmployeeDTO getEmployeeDTO(EmployeeDTO employeeDTO){
        LOGGER.info("Employee : {} ",employeeDTO);
//        throw new RuntimeException();
        return employeeDTO;
    }
}
