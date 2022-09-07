package com.example.springaop.dto;

import com.example.springaop.constant.Pattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer employeeId;
    @NotEmpty(message = "Name field not allowed empty")
    @Size(min=10, max=50,message = "Number character between 10 and 50!!")
    private String name;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthday;
    private Boolean gender;
    @NotEmpty(message = "email field not allowed empty")
    @Email(message = "Email invalid")
    private String email;


}
