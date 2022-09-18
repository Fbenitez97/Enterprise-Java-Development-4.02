package Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmployeeUpdateStatusDto {

    @NotNull
    @Min(0)
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
