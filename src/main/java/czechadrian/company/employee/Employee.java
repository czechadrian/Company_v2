package czechadrian.company.employee;

import czechadrian.company.report.Report;
import czechadrian.company.task.Task;

import java.util.List;

public interface Employee {

    String getName();
    String getSurname();
    Role getRole();
    Gender getGender();
    String getDoMain();
    String getUniversity();
    String getCountry();


    void assign(Task task);
    List<Task> getTasks();

    Report reportWork();
    List<Report> reportWork(List<Report> reports);

    Integer getAmountOfUnitsOfWork();

}