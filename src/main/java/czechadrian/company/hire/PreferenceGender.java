package czechadrian.company.hire;

import czechadrian.company.employee.Employee;
import czechadrian.company.employee.Gender;

import java.util.function.Predicate;

public enum PreferenceGender {


    MALE((i)-> i.getGender().equals(Gender.MALE)," hire only men");


    Predicate predicate;
    String string;

    PreferenceGender(Predicate<Employee> predicate, String string) {
        this.predicate = predicate;
        this.string = string;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public String getString() {
        return string;
    }
}
