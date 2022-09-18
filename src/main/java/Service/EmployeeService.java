package Service;

import Model.Employee;
import Model.EmployeeUpdateStatusDto;
import Model.Status;
import java.util.List;



public interface EmployeeService {

     void addEmployee(Employee employee);

     void setEmployeeStatus(String id, EmployeeUpdateStatusDto status);

     void setEmployeeDepartment(String id, String department);

     List<Employee> allEmployees();
     Employee readEmployeeId(String id);
     Employee readEmployeeStatus(Status status);
     Employee readEmployeeDepartment(String department);
}
