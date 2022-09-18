package Service;

import Model.Employee;
import Model.Patient;
import Model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static Model.Status.OFF;

public interface PatientService {
    void addPatient (Patient patient);
    void setPatients(String id, String name, String dateOfBirth, Employee employee);

    List<Patient> allPatients();
    Patient readPatientId(String id);
    Patient readPatientStatus(Status status);
    Patient readPatientDepartment(String department);


}

