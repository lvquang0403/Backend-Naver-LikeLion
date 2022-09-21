package com.example.week22.repository;

import com.example.week22.model.dto.DepartmentDTO;
import com.example.week22.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MbtRepository {


    @Select("SELECT * , (SELECT COUNT(*) from EMPLOYEE where department_id = #{departmentId}) as num_employee " +
            "FROM DEPARTMENT " +
            "WHERE department_id = #{departmentId}")
    @Results(value = {@Result(property="departmentId", column="department_id"),
            @Result(property="dept_name", column = "dept_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "numEmployee", column = "num_employee")})
    DepartmentDTO findDepartmentById(String departmentId);

    @Select("SELECT *" +
            "FROM EMPLOYEE " +
            "WHERE employee_id = #{id}")
    @Results(value = {@Result(property="name", column="name"),
            @Result(property="birthDate", column = "birth_date"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "department", column = "department", one = @One(select = "findDepartmentById"))})
        //overloading
    EmployeeDTO findEmployeeById(Long id);
}
