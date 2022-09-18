package Service;

import Model.Employee;
import Model.Patient;
import Model.Status;
import Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static Model.Status.*;

public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void addPatient (Patient patient) {
        if (patient == null) {
        throw new IllegalArgumentException("Patient is empty");
    }else {
            patientRepository.save(patient);
        }
    }

    @Override
    public void setPatients(String id, String name, String dateOfBirth, Employee employee) {
        Patient storedPatient = readPatientId(id);
        if (storedPatient == null) {
            throw new IllegalArgumentException("Patient doesn't exist");
        }else {
            storedPatient.setId(id);
            storedPatient.setName(name);
            storedPatient.setDateOfBirth(dateOfBirth);
            storedPatient.setEmployee(employee);
        }
    }

    @Override
    public List<Patient> allPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient readPatientId(String id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hemos encontrado el paciente con código " + id);
        }
    }

    @Override
    public Patient readPatientStatus(Status status) {
        return null;
    }

    @Override
    public Patient readPatientDepartment(String department) {
        return null;
    }


}

    
