package czechadrian.company.report;

import czechadrian.company.employee.Employee;

import java.util.List;

public class ManagerReport extends AbstractReport {

    private List<Report> reports;


    public ManagerReport(Employee employee, List<Report> reports) {
        super(employee);
        this.reports = reports;
    }


    @Override
    public String toString() {
        return "ManagerReport{" +
                "reports=" + reports +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", amountOfUnitsOfWorker=" + amountOfUnitsOfWorker +
                ", role=" + role +
                '}';
    }
}