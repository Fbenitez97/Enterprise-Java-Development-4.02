package Controller;

import Model.Employee;
import Model.Patient;
import Model.Status;
import Service.EmployeeService;
import Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static Model.Status.*;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    @RequestMapping(value="/patients", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient (@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @RequestMapping(value="/patients/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setPatients (@PathVariable String id,@RequestBody String name,@RequestBody String dateOfBirth,@RequestBody Employee employee) {
        patientService.setPatients(id, name, dateOfBirth, employee);
    }

    @RequestMapping(value="/patients", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> allPatients() {
        return patientService.allPatients();
    }

    @RequestMapping(value="/patients/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Patient readPatientId(@PathVariable String id) {
        return patientService.readPatientId(id);
    }



}
