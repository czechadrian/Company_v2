package czechadrian.company.hire;

import czechadrian.company.employee.Employee;

import java.util.function.Predicate;

public enum PreferenceCountry {


    POLAND((i)->i.getCountry().equalsIgnoreCase("POLAND")," hire only from PL");


    Predicate predicate;
    String string;

    PreferenceCountry(Predicate<Employee> predicate, String string) {
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
