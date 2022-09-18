package Controller;

import Model.Employee;
import Model.EmployeeUpdateStatusDto;
import Model.Status;
import Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static Model.Status.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/employees", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee (@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value="/employees/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setEmployeeStatus (@PathVariable String id,@RequestBody EmployeeUpdateStatusDto status) {
        employeeService.setEmployeeStatus(id, status);
    }

    @RequestMapping(value="/employees/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setEmployeeDepartment (@PathVariable String id, @RequestBody String department) {
        employeeService.setEmployeeDepartment(id, department);
    }

    @RequestMapping(value="/employees", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> allEmployees() {
        return employeeService.allEmployees();
    }

    @RequestMapping(value="/employees/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Employee readEmployeeId(@PathVariable String id) {
        return employeeService.readEmployeeId(id);
    }



}