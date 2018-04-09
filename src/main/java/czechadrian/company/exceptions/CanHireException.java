package czechadrian.company.exceptions;

public class CanHireException extends RuntimeException {
    public CanHireException() {
        super("cant hire the employee");
    }
}
