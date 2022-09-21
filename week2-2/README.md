# Week2-2


#### Insert employee
#### /employee/insert
```json
{
    "status": "ok",
    "message": "create successfully",
    "object": {
        "employeeId": 1,
        "name": "Kha33",
        "birthDate": "22/11/2001",
        "gender": true,
        "departmentId": "ROO1"
    }
}
```
#### Get Department BY JPA
##### /department/find/ROO1
```json
{
    "status": "ok",
    "message": "successfully",
    "object": {
        "departmentId": "ROO1",
        "dept_name": "Marketing",
        "description": "Marketing",
        "employees": [
            {
                "employeeId": 1,
                "name": "Kha33",
                "birthDate": "22/11/2001",
                "gender": true,
                "departmentId": "ROO1"
            }
        ]
    }
}
```
---
#### Get Department By Mybatis
##### GET /department/findV2/ROO1
```json
{
    "status": "ok",
    "message": "successfully",
    "object": {
        "departmentId": "ROO1",
        "dept_name": "Marketing",
        "description": "Marketing",
        "numEmployee": 1
    }
}
```
##### Get Employee By Mybatis
##### /employee/findV2/1
```json
{
    "status": "ok",
    "message": "successfully",
    "object": {
        "name": "Kha33",
        "birthDate": "2001-11-22T00:00:00.000+00:00",
        "gender": true,
        "department": {
            "departmentId": "ROO1",
            "dept_name": "Marketing",
            "description": "Marketing",
            "numEmployee": 1
        }
    }
}
```
---
## 2. Singleton + Factory Pattern
#### GET PC and Server
#### /factory-method/pc
#### /factory-method/server
![image](https://user-images.githubusercontent.com/104447131/187057678-37982885-213a-490d-b5ce-a12c5f6a8442.png)

```

