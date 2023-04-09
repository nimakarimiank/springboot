package illutech.com.mvc.controllers;


import illutech.com.database.dao.entities.Employee;
import illutech.com.service.implementation.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()//("/AddEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);


    }


}
