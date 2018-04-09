package czechadrian.company.employee;

import czechadrian.company.report.Report;
import czechadrian.company.report.WorkerReport;
import czechadrian.company.task.Task;

import java.util.List;

public class Developer extends AbstractEmployee {

    Developer(Builder employeeBuilder) {
        super(employeeBuilder);
    }

    @Override
    public void assign(Task task) {
        System.out.println(this.getName() +" "+this.getSurname()+" "+this.getRole()
                +" university: "+this.getUniversity()+ " added task: " + task.toString());

        tasks.add(task);
        amountOfUnitsOfWork += task.getUnitsOfWork();
    }

    @Override
    public List<Report> reportWork(List<Report> reports) {
        reports.add(new WorkerReport(this));
        return reports;
    }

    @Override
    public Report reportWork() {
        return new WorkerReport(this);
    }

    public static class Builder extends AbstractEmployee.Builder<Builder> {
        EmployeeGenerator employeeGenerator = new EmployeeGenerator();
        public Builder(String name,String surname,String domain,String country){

            super(name,surname,domain,country);
            super.role(employeeGenerator.getDevsRole());
        }

        public Developer buildEmployee() {
            return new Developer(this);
        }


    }





}