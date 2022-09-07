# Week3-2

* [Employee API](#employee-api)
  * [POST Employee with invalid value](#post-employee-with-invalid-value-name)
  * [POST Employee with invalid value name](#post-employee-with-invalid-value)
  * [Spring AOP : Exception at getEmployeeDTO method in EmployeeDTOServiceImpl](#spring-aop--exception-at-getemployeedto-method-in-employeedtoserviceimpl)
  * [POST Employee with valid value (Successfully)](#post-employee-with-valid-value-ok)


* [Department API](#department-api)
  * [POST Department with invalid value](#post-department-with-invalid-value)
  * [POST Department with valid value (Successfully)](#post-department-with-valid-value-successfully)

## Project Configuration
- application.properties
```
server.servlet.context-path=/likelion
server.port=9081
logging.pattern.console= %d{yyyy-MM-dd HH:mm:ss} | %-5level | %logger{1.} | %msg%n
logging.level.root=TRACE
```

## Employee API
### POST Employee with invalid value
- Request

```json
POST localhost:9081/likelion/employee
    {
        "employeeId":1,
        "name":"sds",
        "birthday": "04-03-2001",
        "gender":true,
        "email":"vinhquang1873@@@gmail.com"

    }
```
- Response
```json
{
    "status": "Fail",
    "message": "Argument Not Valid !!",
    "detailData": {
        "name": "Number character between 10 and 50!!",
        "email": "Email invalid"
    }
}
```

### POST Employee with invalid value name
- Request

```json
localhost:9081/likelion/employee
    {
        "employeeId":1,
        "name":"sds",
        "birthday": "04-03-2001",
        "gender":true,
        "email":"vinhquang1873@gmail.com"

    }
```
- Response
```json
{
    "status": "Fail",
    "message": "Argument Not Valid !!",
    "detailData": {
        "name": "Number character between 10 and 50!!"
    }
}
```

### Spring AOP : Exception at getEmployeeDTO method in EmployeeDTOServiceImpl

- Log
```
2022-09-07 17:46:27.141  INFO 11216 --- [nio-9081-exec-6] c.e.s.s.impl.EmployeeDTOServiceImpl      : Employee : EmployeeDTO(employeeId=1, name=Le Vinh Quang, birthday=2001-03-04, gender=true, email=vinhquang1873@gmail.com) 
2022-09-07 17:46:27.154  INFO 11216 --- [nio-9081-exec-6] c.e.s.aspect.LoggingServiceAspect        : after GetEmployeeDTO failed call !!
```

### POST Employee with valid value (Successfully)
- Request

```json
POST localhost:9081/likelion/employee
{
    {
        "employeeId":1,
        "name":"Le Vinh Quang",
        "birthday": "04-03-2001",
        "gender":true,
        "email":"vinhquang1873@gmail.com"

    }
}
```
- Response
```json
{
    "status": "ok",
    "message": "Successfully",
    "detailData": {
        "employeeId": 1,
        "name": "Le Vinh Quang",
        "birthday": "04-03-2001",
        "gender": true,
        "email": "vinhquang1873@gmail.com"
    }
}
```
---
## Department API
### POST Department with invalid value
- Request

```
POST localhost:9081/likelion/department
{
"departmentId" : 1,
"deptName" : "",
"description" : "description",
"listEmployee" :
[
    {
        "employeeId":1,
        "name":"",
        "birthday": "04-03-2001",
        "gender":true,
        "email":"vinhquang1873@@ggmail.com"

    }
]
}
```
- Response
```json
{
    "status": "Fail",
    "message": "Argument Not Valid !!",
    "detailData": {
        "deptName": "department name field not allowed empty",
        "listEmployee[0].email": "Email invalid",
        "listEmployee[0].name": "Number character between 10 and 50!!"
    }
}
```

### POST Department with valid value (Successfully)
- Request

```
POST localhost:9081/likelion/department
{
"departmentId" : 1,
"deptName" : "Maketing room",
"description" : "description",
"listEmployee" :
[
    {
        "employeeId":1,
        "name":"Le Vinh Quang",
        "birthday": "04-03-2001",
        "gender":true,
        "email":"vinhquang1873@gmail.com"

    }
]
}
```
- Response
```json
{
    "status": "ok",
    "message": "Successfully",
    "detailData": {
        "departmentId": 1,
        "deptName": "Maketing room",
        "description": "description",
        "listEmployee": [
            {
                "employeeId": 1,
                "name": "Le Vinh Quang",
                "birthday": "04-03-2001",
                "gender": true,
                "email": "vinhquang1873@gmail.com"
            }
        ]
    }
}
```
- Log
```
2022-09-07 17:58:41.972  INFO 26720 --- [nio-9081-exec-7] c.e.s.aspect.LoggingServiceAspect        : before called with args DepartmentDTO(departmentId=1, deptName=Maketing room, description=description, listEmployee=[EmployeeDTO(employeeId=1, name=Le Vinh Quang, birthday=2001-03-04, gender=true, email=vinhquang1873@gmail.com)]) 
2022-09-07 17:58:41.972  INFO 26720 --- [nio-9081-exec-7] c.e.s.s.impl.DepartmentDTOServiceImpl    : Into getDepartmentDTO method : DepartmentDTO(departmentId=1, deptName=Maketing room, description=description, listEmployee=[EmployeeDTO(employeeId=1, name=Le Vinh Quang, birthday=2001-03-04, gender=true, email=vinhquang1873@gmail.com)])
2022-09-07 17:58:41.973  INFO 26720 --- [nio-9081-exec-7] c.e.s.aspect.LoggingServiceAspect        : after called with args DepartmentDTO(departmentId=1, deptName=Maketing room, description=description, listEmployee=[EmployeeDTO(employeeId=1, name=Le Vinh Quang, birthday=2001-03-04, gender=true, email=vinhquang1873@gmail.com)]) 
```



