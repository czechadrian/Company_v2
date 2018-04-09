package czechadrian.company.hire;

import czechadrian.company.employee.Employee;

import java.util.function.Predicate;

public enum PreferenceNull {

    ALWAYS_HIRE((i)->true," hire without preferences");

    Predicate predicate;
    String string;

    PreferenceNull(Predicate<Employee> predicate,String string) {
        this.predicate = predicate;
        this.string=string;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public String getString() {
        return string;
    }
}
