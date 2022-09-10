package Controller;

import Model.Employee;
import Model.Patient;
import Model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static Model.Status.*;

@RestController
public class PatientController {
    private List<Patient> patientsRepo;
   Employee employee = new Employee("45af", "magico", ON_CALL, "RANRAN");

    public PatientController(){
        patientsRepo = new ArrayList<>();

        patientsRepo.add(new Patient("45af","Manolo", "29-09-1997", employee));
        patientsRepo.add(new Patient("45af","paco", "06-12-1999", employee));
    }

    @RequestMapping(value="/patients", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient (@RequestBody Patient patient) {
        patientsRepo.add(patient);
    }

    @RequestMapping(value="/patients/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setPatients (@RequestBody Patient patient,String id, String name, String dateOfBirth, Employee employee) {
        patient.setId(id);
        patient.setName(name);
        patient.setDateOfBirth(dateOfBirth);
        patient.setEmployee(employee);
    }


}
