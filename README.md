# Week3-2

* [Employee API](#post-employee-api)
  * [Case 1: Error at Controller - Get Employee with invalid @ResponseBody(name, email)](#case-1-error-at-controller---get-employee-with-invalid-responsebodyname-email)
  * [Case 2: Error at Controller - Get Employee with invalid @ResponseBody(email)](#case-2-error-at-controller---get-employee-with-invalid-responsebodyemail)
  * [Case 3: Error at Service - Get Employee with valid @ResponseBody and Service throws Exception](#case-3-error-at-service---get-employee-with-valid-responsebody-and-service-throws-exception)
  * [Case 4: Success - Get Employee with valid @ResponseBody and Service gets Dto successfully](#case-4-success---get-employee-with-valid-responsebody-and-service-gets-dto-successfully)


* [Get Department API](#get-department-api)
  * [Case 1: Error at Controller - Get Department with invalid @ResponseBody(deptName, description)](#case-1-error-at-controller---get-department-with-invalid-responsebodydeptname-description)
  * [Case 2: Error at Controller - Get Department with invalid @ResponseBody(deptName, employeeDtos)](#case-2-error-at-controller---get-department-with-invalid-responsebodydeptname-employeedtos)
  * [Case 3: Success - Get Department with valid @ResponseBody](#case-3-success---get-department-with-valid-responsebody)


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

### POST Employee with valid value (OK)
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
## Get Department API
### Case 1: Error at Controller - Get Department with invalid @ResponseBody(deptName, description)
- Request

```
GET /likelion/test-department-dto
{
    "departmentId": 1,
    "deptName": "Phong 1",
    "desciption": "",
    "employeeDtos": [
        {
            "employeeId": 1,
            "name": "Nhan vien 1",
            "birthDate": "2000-01-01",
            "gender": "male",
            "email": "fd@gmail.com"
        }
    ]
}
```
- Response
```json
{
  "status": "error",
  "data": null,
  "message": "Argument not valid: ['deptName': 'Department name only accept 10-50 characters', 'desciption': 'Desciption cannot be empty']"
}
```

### Case 2: Error at Controller - Get Department with invalid @ResponseBody(deptName, employeeDtos)
- Request

```
GET /likelion/test-department-dto
{
    "departmentId": 1,
    "deptName": "Phong 1",
    "desciption": "Day la phong so 1",
    "employeeDtos": [
        {
            "employeeId": 1,
            "name": "Nv 1",
            "birthDate": "2000-01-01",
            "gender": "male",
            "email": "000abcgmail.com"
        }
    ]
}
```
- Response
```json
{
  "status": "error",
  "data": null,
  "message": "Argument not valid: ['deptName': 'Department name only accept 10-50 characters', 'employeeDtos[0].email': 'Gmail address is not valid', 'employeeDtos[0].name': 'Name only accept 10-50 characters']"
}
```

### Case 3: Success - Get Department with valid @ResponseBody
- Request

```
GET /likelion/test-department-dto
{
    "departmentId": 1,
    "deptName": "Phong 11111111",
    "desciption": "Day la phong so 1",
    "employeeDtos": [
        {
            "employeeId": 1,
            "name": "Nhan vien 1",
            "birthDate": "2000-01-01",
            "gender": "male",
            "email": "abc@gmail.com"
        }
    ]
}
```
- Response
```json
{
  "status": "success",
  "data": {
    "departmentId": 1,
    "deptName": "Phong 11111111",
    "desciption": "Day la phong so 1",
    "employeeDtos": [
      {
        "employeeId": 1,
        "name": "Nhan vien 1",
        "birthDate": "2000-01-01T00:00:00.000+00:00",
        "gender": "male",
        "email": "abc@gmail.com"
      }
    ]
  },
  "message": null
}
```
- Log
```
2022-09-07 15:57:39.702 - INFO 40009 --- [http-nio-9081-exec-2] com.example.week32.aspect.LoggingAspect :   21 : Before execution(DepartmentDto com.example.week32.service.impl.DepartmentServiceImpl.getDepartmentDto(DepartmentDto))
2022-09-07 15:57:39.745 - INFO 40009 --- [http-nio-9081-exec-2] com.example.week32.aspect.LoggingAspect :   26 : After execution(DepartmentDto com.example.week32.service.impl.DepartmentServiceImpl.getDepartmentDto(DepartmentDto))
```



