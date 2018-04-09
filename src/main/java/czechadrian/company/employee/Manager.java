package czechadrian.company.employee;

import czechadrian.company.report.Report;
import czechadrian.company.task.Task;

import java.util.List;
public interface Manager extends Employee {

    void hire(Employee employee);
    void fire(Employee employee);

    boolean canHire(Employee employee);

    Employee getWorkerWithLowestWorkload();

}