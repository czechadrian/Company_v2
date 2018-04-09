package czechadrian.company.hire;

import czechadrian.company.employee.Employee;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum PreferenceUniversity {


    AGH((i)-> i.getUniversity().equalsIgnoreCase("AGH")," hire only graduated from AGH");


    Predicate predicate;
    String string;

    PreferenceUniversity(Predicate<Employee> predicate, String string) {
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
