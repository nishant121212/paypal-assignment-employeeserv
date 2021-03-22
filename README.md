# employeeserv

## Application Overview
employeeserv is a spring boot rest application which would provide the CRUD operations for `Employee` resource.

There are three modules in this application
- employeeservApi - This module contains the interface.
	- `v1/schema/employee.json` defines the employee resource.
	- `jsonschema2pojo-maven-plugin` is being used to create `Employee POJO` from json file.
	- `EmployeeResource.java` is the interface for CRUD operations on `Employee` resource.
		- GET `/v1/bfs/employees/{id}` endpoint is defined to fetch the resource.
- employeeservImplementation - This module contains the implementation for the rest endpoints.
	- `EmployeeResourceImpl.java` implements the `EmployeeResource` interface.
- employeeservFunctionalTests - This module would have the functional tests.

## How to run the application
- Please have Maven version `3.3.3` & Java 8 on your system.
- Use command `mvn clean install` to build the project.
- Use command `mvn spring-boot:run` from `employeeservImplementation` folder to run the project.
- Use postman or curl to access `http://localhost:8080/v1/bfs/employees/1` GET endpoint. It will return an Employee resource.

## Assignment
We would like you to enhance the existing project and see you complete the following requirements:

- `employee.json` has only `name`, and `id` elements. Please add `date of birth` and `address` elements to the `Employee` resource. Address will have `line1`, `line2`, `city`, `state`, `country` and `zip_code` elements. `line2` is an optional element.
- Add one more operation in `EmployeeResource` to create an employee. `EmployeeResource` will have two operations, one to create, and another to retrieve the employee resource.
- Implement create and retrieve operations in `EmployeeResourceImpl.java`.
- Resource created using create endpoint should be retrieved using retrieve/get endpoint.
- Please use h2 in-memory database or any other in-memory database to persist the `Employee` resource. Dependency for h2 in-memory database is already added to the parent pom.
- Please make sure the validations are done for the requests.
- Response codes are as per rest guidelines.
- Error handling in case of failures.

## Assignment submission
Thank you very much for your time to take this test. Please upload this complete solution in Github and send us the link to `bfs-sor-interview@paypal.com`.

## Postman API collection
https://www.getpostman.com/collections/a88aac2ca7b34629f636

## Error codes
    BAD_REQUEST("E00001", "Invalid request"),
    METHOD_NOT_ALLOWED("E00002", "Http request method not supported"),
    UNSUPPORTED_MEDIA_TYPE("E00003", "Http media type not supported"),
    NOT_ACCEPTABLE("E00004", "Http media type not acceptable"),
    EMPLOYEE_NOT_FOUND("E00005", "Requested employee does not exist"),
    EMPLOYEE_SERVICE_EXCPTION("E00006", "Something went wrong, Please try later"),
    INTERNAL_SERVER_ERROR("E00007", "Currently, we are unable to serve your request. Please try again later"),
    DATA_BASE_EXCEPTION("E00008", "Currently, we are unable to serve your request. Please try again later");
    
    
## Sample request-response
```bash
create employee
$ curl -X POST \
  http://localhost:8080/v1/bfs/employees \
  -H 'content-type: application/json' \
  -d '{
    "first_name": "Nishant",
    "last_name": "kumar",
    "dateOfBirth": "01-01-1990",
    "address": {
        "line1": "address line 1",
        "line2": "address line 2 - optional",
        "city": "new delhi",
        "state": "delhi",
        "country": "India",
        "zip_code": 110011
    }
}'

$ {"id":1,"first_name":"Nishant","last_name":"kumar","dateOfBirth":"01-01-1990","address":{"line1":"address line 1","line2":"address line 2 - optional","city":"new delhi","state":"delhi","country":"India","zip_code":110011}}

status code - 201 (CREATED)
location →/v1/bfs/employees/1
```
```bash
get employee
$ curl -X GET \
  http://localhost:8080/v1/bfs/employees/1 \
  
$ {"id":1,"first_name":"Nishant","last_name":"kumar","dateOfBirth":"01-01-1990","address":{"line1":"address line 1","line2":"address line 2 - optional","city":"new delhi","state":"delhi","country":"India","zip_code":110011}}

status code - 200 (OK)
```


```bash
no employee found
$ curl -X GET \
  http://localhost:8080/v1/bfs/employees/12 \
  
$ {"code":"E00005","message":"Requested employee does not exist"}  

status code - 404
```

```bash
validation failure
$ curl -X POST \
  http://localhost:8080/v1/bfs/employees \
  -H 'content-type: application/json' \
  -d '{
    "first_name": "Nishant",
    "last_name": "kumar",
    "dateOfBirth": "01-01-1990",
    "address": {
        "line1": "address line 1",
        "line2": "address line 2 - optional",
        "city": "new delhi",
        "state": "delhi",
        "country": "India",
        "zip_code": 110011
    }
}'

$ {
    "code": "E00001",
    "message": "Invalid request",
    "fieldValidation": [
        {
            "field": "address.line1",
            "message": "size must be between 1 and 255"
        },
        {
            "field": "address.city",
            "message": "must not be null"
        },
        {
            "field": "firstName",
            "message": "must not be null"
        }
    ]
}

status code - 400
```



