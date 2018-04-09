package czechadrian.company.report;

import czechadrian.company.employee.Employee;
import czechadrian.company.task.Task;

import java.util.List;

public class WorkerReport extends AbstractReport {

    private List<Task> tasks;

    public WorkerReport(Employee employee) {
        super(employee);
        this.tasks = employee.getTasks();
    }

    @Override
    public String toString() {
        return "WorkerReport{" +
                "tasks=" + tasks +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", amountOfUnitsOfWorker=" + amountOfUnitsOfWorker +
                ", role=" + role +
                '}';
    }
}