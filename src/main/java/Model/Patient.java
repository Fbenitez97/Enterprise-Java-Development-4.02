package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Model.Patient")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient {

    @Id
    private String id;
    private String name;
    private String dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;


    public Patient(String id, String name, String dateOfBirth, Employee employee) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}