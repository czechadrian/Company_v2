import czechadrian.company.employee.*;
import czechadrian.company.hire.PreferenceNull;
import czechadrian.company.report.Report;
import czechadrian.company.task.TaskGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String args[]) {

            Random rand = new Random();

            int levels = rand.nextInt(4) + 1;
            int size = rand.nextInt(4) + 1;

            EmployeeGenerator employeeGenerator = new EmployeeGenerator();
            TaskGenerator taskGenerator = new TaskGenerator();

            List<Employee> otherEmployeeList = new ArrayList<>();

            List<Employee> employeeList = new ArrayList<>();

            employeeList.addAll(employeeGenerator.getDevelopers((int) Math.pow(size, levels)));

            TeamManager ceo = new TeamManager.Builder("Elon","Musk","elon@tesla.com",
                    "USA",size).gender(Gender.MALE)
                    .role(Role.CEO).university("AGH").buildEmployee();

            if (levels == 1) {
                for (Employee dev : employeeList) {
                    ceo.hire(dev);
                }
            } else {
                List<Manager> managersList = employeeGenerator.getManagers(size, (int) Math.pow(size, levels - 1));

                int num1 = 0;
                for (Manager manager : managersList) {
                    for (int i = 0; i < size; i++) {
                        manager.hire(employeeList.get(num1));
                        num1++;
                    }
                }

                for (int i = levels - 1; i > 1; i--) {
                    otherEmployeeList.addAll(managersList);
                    managersList = employeeGenerator.getManagers(size, (int) Math.pow(size, i - 1));
                    int num2 = 0;
                    for (Manager manager : managersList) {
                        for (int j = 0; j < size; j++) {
                            manager.hire(otherEmployeeList.get(num2));
                            num2++;
                        }
                    }
                    otherEmployeeList.clear();
                }

                for (Employee employee : managersList) {
                    ceo.hire(employee);
                }
            }
            int numOfTasks = rand.nextInt(40)+10;

            for(int i = 0;i<numOfTasks;i++) {
                ceo.assign(taskGenerator.addTask());
            }
            Report report = ceo.reportWork();

            System.out.println("\n\n"+report.toString());


            System.out.println("\n\nCEO " + ceo.getName() + " " + ceo.getSurname() + " hired employees with preferences: "
            + ceo.printPreferenceNull());


        }
    }

