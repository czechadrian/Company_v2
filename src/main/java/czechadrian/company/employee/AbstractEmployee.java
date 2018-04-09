package czechadrian.company.employee;

import czechadrian.company.task.Task;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractEmployee implements Employee {

    private Role role;
    private final String name;
    private final String surname;
    final List<Task> tasks;
    Integer amountOfUnitsOfWork;
    private final Gender gender;
    private final String university;
    private final String domain;
    private final String country;


    public AbstractEmployee(Builder employeeBuilder) {
        this.role = employeeBuilder.role;
        this.name = employeeBuilder.name;
        this.surname = employeeBuilder.surname;
        this.tasks = new ArrayList<>();
        this.amountOfUnitsOfWork = 0;
        this.country=employeeBuilder.country;
        this.domain=employeeBuilder.domain;
        this.gender=employeeBuilder.gender;
        this.university=employeeBuilder.university;

    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public String getUniversity() {
        return university;
    }

    public String getDoMain() {
        return domain;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Integer getAmountOfUnitsOfWork() {
        return amountOfUnitsOfWork;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public static abstract class Builder<T> {
        private Role role;
        private Gender gender;
        private String university;
        private final String name;
        private final String surname;
        private final String domain;
        private final String country;

        Builder(String name,String surname,String domain,String country) {
            this.country=country;
            this.name = name;
            this.surname = surname;
            this.domain = domain;
        }

        public T gender(Gender gender) {
            this.gender = gender;

            return (T)this;
        }

        public T role(Role role) {
            this.role = role;

            return (T) this;
        }

        public T university(String university) {
            this.university = university;

            return (T)this;
        }

        public abstract AbstractEmployee buildEmployee();

    }

}