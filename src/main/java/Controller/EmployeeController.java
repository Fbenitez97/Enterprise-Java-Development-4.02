package Controller;

import Model.Employee;
import Model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static Model.Status.*;

@RestController
public class EmployeeController {
    private List<Employee> employeesRepo;

    public EmployeeController(){
        employeesRepo = new ArrayList<>();

        employeesRepo.add(new Employee("45af","Magico", ON_CALL, "Ranran"));
        employeesRepo.add(new Employee("97fb","Auror", ON, "Paco"));
    }

    @RequestMapping(value="/employees", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee (@RequestBody Employee employee) {
        employeesRepo.add(employee);
    }

    @RequestMapping(value="/employees/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setEmployeeStatus (@RequestBody Employee employee, Status status) {
        employee.setStatus(status);
    }

    @RequestMapping(value="/employees/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setEmployeeDepartment (@RequestBody Employee employee, String department) {
        employee.setDepartment(department);
    }



}