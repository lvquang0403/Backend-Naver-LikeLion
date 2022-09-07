# Week3-2

* [POST Employee API](#post-employee-api)
  * [Case 1: Error at Controller - Get Employee with invalid @ResponseBody(name, email)](#case-1-error-at-controller---get-employee-with-invalid-responsebodyname-email)
  * [Case 2: Error at Controller - Get Employee with invalid @ResponseBody(email)](#case-2-error-at-controller---get-employee-with-invalid-responsebodyemail)
  * [Case 3: Error at Service - Get Employee with valid @ResponseBody and Service throws Exception](#case-3-error-at-service---get-employee-with-valid-responsebody-and-service-throws-exception)
  * [Case 4: Success - Get Employee with valid @ResponseBody and Service gets Dto successfully](#case-4-success---get-employee-with-valid-responsebody-and-service-gets-dto-successfully)


* [Get Department API](#get-department-api)
  * [Case 1: Error at Controller - Get Department with invalid @ResponseBody(deptName, description)](#case-1-error-at-controller---get-department-with-invalid-responsebodydeptname-description)
  * [Case 2: Error at Controller - Get Department with invalid @ResponseBody(deptName, employeeDtos)](#case-2-error-at-controller---get-department-with-invalid-responsebodydeptname-employeedtos)
  * [Case 3: Success - Get Department with valid @ResponseBody](#case-3-success---get-department-with-valid-responsebody)


## POST Employee API
### POST Employee with invalid @ResponseBody(name, email)
- Request

```
GET /likelion/test-employee-dto
{
    "employeeId": 1,
    "name": "",
    "birthDate": "2000-01-01",
    "gender": "male",
    "email": "abc@email.com"
}
```
- Response
```json
{
  "status": "error",
  "data": null,
  "message": "Argument not valid: ['name': 'Name cannot be empty', 'email': 'Gmail address is not valid', 'name': 'Name only accept 10-50 characters']"
}
```

### Case 2: Error at Controller - Get Employee with invalid @ResponseBody(email)
- Request

```
GET /likelion/test-employee-dto
{
    "employeeId": 1,
    "name": "Nhan vien 1",
    "birthDate": "2000-01-01",
    "gender": "male",
    "email": "abc@yahoo.com"
}
```
- Response
```json
{
  "status": "error",
  "data": null,
  "message": "Argument not valid: ['email': 'Gmail address is not valid']"
}
```

### Case 3: Error at Service - Get Employee with valid @ResponseBody and Service throws Exception 
- Request

```
GET /likelion/test-employee-dto
{
    "employeeId": 1,
    "name": "Nhan vien 1",
    "birthDate": "2000-01-01",
    "gender": "male",
    "email": "anh.vn00@gmail.com"
}
```
- Response
```json
{
  "status": "error",
  "data": null,
  "message": "An exception occurred while getting DTO"
}
```
- Log
```
2022-09-07 15:42:52.839 -ERROR 36737 --- [http-nio-9081-exec-8] com.example.week32.aspect.LoggingAspect :   31 : Get An exception occurred while getting DTO at execution(EmployeeDto com.example.week32.service.impl.EmployeeServiceImpl.getEmployeeDto(EmployeeDto))
```

### Case 4: Success - Get Employee with valid @ResponseBody and Service gets Dto successfully 
- Request

```
GET /likelion/test-employee-dto
{
    "employeeId": 1,
    "name": "Nhan vien 1",
    "birthDate": "2000-01-01",
    "gender": "male",
    "email": "anh.vn00@gmail.com"
}
```
- Response
```json
{
  "status": "success",
  "data": {
    "employeeId": 1,
    "name": "Nhan vien 1",
    "birthDate": "2000-01-01T00:00:00.000+00:00",
    "gender": "male",
    "email": "anh.vn00@gmail.com"
  },
  "message": null
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



