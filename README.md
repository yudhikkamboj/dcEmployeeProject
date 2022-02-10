# dcEmployeeProject

Command to run the application : gradlew bootrun

Endpoints : 

GET : localhost:8080/employees/ <br/>
GET : localhost:8080/employee/?empId=123 <br/>
POST : localhost:8080/employee/ <br/>
PUT : localhost:8080/employee/?empId=1234&attr=employeeEmail&value=something@gmail.com <br/>
DELETE : localhost:8080/employee/?empId=123 <br/>


Sample request body to save employee data :

{
    "employeeId" : 1234,
    "employeeName" : "theName1",
    "employeeEmail" : "theMail1",
    "location" : "theLocation1"
}
