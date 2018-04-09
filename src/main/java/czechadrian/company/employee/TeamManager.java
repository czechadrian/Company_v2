package czechadrian.company.employee;


import czechadrian.company.exceptions.CanHireException;
import czechadrian.company.hire.*;
import czechadrian.company.report.ManagerReport;
import czechadrian.company.report.Report;
import czechadrian.company.report.WorkerReport;
import czechadrian.company.task.Task;

import java.util.*;

public class TeamManager extends AbstractEmployee implements Manager {

    private final List<Employee> workerList;
    private int limitOfWorkers;
    private PreferenceMail preferenceMail;
    private PreferenceCountry preferenceCountry;
    private PreferenceUniversity preferenceUniversity;
    private PreferenceGender preferenceGender;
    private PreferenceNull preferenceNull;

    TeamManager(Builder employeeBuilder) {
        super(employeeBuilder);
        this.workerList = new ArrayList<>();
        this.limitOfWorkers = employeeBuilder.limitOfWorkers;
        this.preferenceMail = employeeBuilder.preferenceMail;
        this.preferenceCountry = employeeBuilder.preferenceCountry;
        this.preferenceGender=employeeBuilder.preferenceGender;
        this.preferenceUniversity = employeeBuilder.preferenceUniversity;
        this.preferenceNull = employeeBuilder.preferenceNull;
    }

    @Override
    public boolean canHire(Employee employee) {
        return (limitOfWorkers > workerList.size()) &&
                preferenceNull.getPredicate().test(employee);
    }

    @Override
    public void hire(Employee employee) {
        if (canHire(employee))
            workerList.add(employee);
        else
            throw new CanHireException();
    }

    @Override
    public void fire(Employee employee) {
        if (!workerList.contains(employee))
            throw new NoSuchElementException("Impossible to fire the employee");
        else
            workerList.remove(employee);
    }
    @Override
    public Employee getWorkerWithLowestWorkload() {

        Optional<Employee> workerWithLowestWorkload = workerList.stream()
                .min(Comparator.comparing(Employee::getAmountOfUnitsOfWork));

        return workerWithLowestWorkload.orElseThrow(NoSuchElementException::new);

    }

    @Override
    public void assign(Task task) {

        Employee employee = getWorkerWithLowestWorkload();

        System.out.println(this.getName() + " " + this.getSurname() + " " + this.getRole() + " uni: " + this.getUniversity()
                + " added task: " + task.toString() + " to worker: " + employee.getName()
                + " " + employee.getSurname() + " " + employee.getRole() + " with actual: "
                + employee.getAmountOfUnitsOfWork() + " amount units of works");

        employee.assign(task);
        tasks.add(task);
        amountOfUnitsOfWork += task.getUnitsOfWork();

    }

    public String printPreferenceMail() {
        return preferenceMail.toString();
    }
    public String printPreferenceUniversity() {
        return preferenceUniversity.toString();
    }
    public String printPreferenceGender() {
        return preferenceGender.toString();
    }
    public String printPreferenceCountry() {
        return preferenceCountry.toString();
    }
    public String printPreferenceNull() {
        return preferenceNull.toString();
    }

    @Override
    public Report reportWork() {

        List<Report> reportList = new ArrayList<>();

        workerList.forEach(employee -> employee.reportWork(reportList));

        return new ManagerReport(this, reportList);
    }

    @Override
    public List<Report> reportWork(List<Report> reports) {

        workerList.forEach(employee -> employee.reportWork(reports));

        reports.add(new WorkerReport(this));

        return reports;
    }

    public static class Builder extends AbstractEmployee.Builder<Builder> {
        private final int limitOfWorkers;
        private PreferenceMail preferenceMail = PreferenceMail.GMAIL;
        private PreferenceCountry preferenceCountry = PreferenceCountry.POLAND;
        private PreferenceGender preferenceGender = PreferenceGender.MALE;
        private PreferenceUniversity preferenceUniversity = PreferenceUniversity.AGH;
        private PreferenceNull preferenceNull = PreferenceNull.ALWAYS_HIRE;

        EmployeeGenerator employeeGenerator = new EmployeeGenerator();

        public Builder(String name, String surname, String domain, String country, int limitOfWorkers) {
            super(name, surname, domain, country);
            this.limitOfWorkers = limitOfWorkers;
            super.role(employeeGenerator.getManagersRole());
        }
        public TeamManager buildEmployee() {
            return new TeamManager(this);
        }
    }

}