package czechadrian.company.report;

import czechadrian.company.employee.Employee;
import czechadrian.company.employee.Role;

public abstract class AbstractReport implements Report {

    public final String name;
    public final String surname;
    final Integer amountOfUnitsOfWorker;
    final Role role;

    public AbstractReport(Employee employee) {
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.amountOfUnitsOfWorker = employee.getAmountOfUnitsOfWork();
        this.role = employee.getRole();
    }

    @Override
    public Integer getAmountOfWork() {
        return amountOfUnitsOfWorker;
    }

    @Override
    public String getSurnameOfWorker() {
        return surname;
    }

    @Override
    public String getNameOfWorker() {
        return name;
    }

    @Override
    public Role getRole() {
        return role;
    }
}