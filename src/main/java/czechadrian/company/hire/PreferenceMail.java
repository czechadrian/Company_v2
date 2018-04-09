package czechadrian.company.hire;

import czechadrian.company.employee.Employee;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum PreferenceMail {

    GMAIL((i)-> Pattern.matches("[a-zA-Z0-9łŁśŚąĄćĆęĘoÓżŻźŹńŃ._]+@gmail\\.com",i.getDoMain())," hire only GMAIL");



    Predicate predicate;
    String string;

    PreferenceMail(Predicate<Employee> predicate, String string) {
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
