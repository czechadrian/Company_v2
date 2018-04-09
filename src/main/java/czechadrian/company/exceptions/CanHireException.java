package czechadrian.company.exceptions;

public class CanHireException extends RuntimeException {
    public CanHireException() {
        System.out.println("cant hire the employee");//super("cant hire the employee");
    }
}
