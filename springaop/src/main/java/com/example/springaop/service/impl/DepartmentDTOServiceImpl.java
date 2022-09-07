package com.example.springaop.service.impl;

import com.example.springaop.dto.DepartmentDTO;
import com.example.springaop.service.DepartmentDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDTOServiceImpl implements DepartmentDTOService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDTOServiceImpl.class);
    @Override
    public DepartmentDTO getDepartmentDTO(DepartmentDTO departmentDTO) {
        LOGGER.info("Into getDepartmentDTO method : {}", departmentDTO);
        try {
            return departmentDTO;
        }
        catch (Exception e){
            LOGGER.info(e.toString());
            return null;
        }
    }
}
