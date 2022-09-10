package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Model.Employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

        @Id
        private String employeeId;
        private String department;
        private Status status;
        private String name;

        public Employee(String employeeId, String department, Status status, String name) {
                this.employeeId = employeeId;
                this.department = department;
                this.status = status;
                this.name = name;
        }

        public String getEmployeeId() {
                return employeeId;
        }

        public void setEmployeeId(String employeeId) {
                this.employeeId = employeeId;
        }

        public String getDepartment() {
                return department;
        }

        public void setDepartment(String department) {
                this.department = department;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
                if (!(obj instanceof Employee)) {
                        return false;
                }

                Employee employeeObj = (Employee) obj;

                if (employeeId.equals(employeeObj.getEmployeeId())) {
                        return true;
                }
                return false;
        }
}
