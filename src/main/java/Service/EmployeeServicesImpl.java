package Service;

import Model.Employee;
import Model.EmployeeUpdateStatusDto;
import Model.Status;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class EmployeeServicesImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {
        if (employee == null) {
        throw new IllegalArgumentException("Employee doesn't exist");
    }else{
        employeeRepository.save(employee);
        }
    }

    @Override
    public void setEmployeeStatus(String id, EmployeeUpdateStatusDto status) {
        if (id == null) {
                throw new IllegalArgumentException("Employee doesn't exist");
            }else{
            Employee storedEmployee = readEmployeeId(id);
            storedEmployee.setStatus(status.getStatus());
        }
    }

    @Override
    public void setEmployeeDepartment(String id, String department) {
        if (id == null) {
        throw new IllegalArgumentException("Employee doesn't exist");
    }else{
        employeeRepository.getReferenceById(id).setDepartment(department);
        }
    }

    @Override
    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee readEmployeeId(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hemos encontrado el empleado con código " + id);
        }
    }

    @Override
    public Employee readEmployeeStatus(Status status) {
        return null;
    }

    @Override
    public Employee readEmployeeDepartment(String department) {
        return null;
    }

}
