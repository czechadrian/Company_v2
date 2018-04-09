package czechadrian.company.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeGenerator {

    private final PersonGenerator personGenerator = new PersonGenerator();

    Random rand = new Random();


    public TeamManager getManager(int size) {
        String name = personGenerator.getName();
        String surname = personGenerator.getSurname();
        String mail = name + surname + personGenerator.getMail();
        String university = personGenerator.getUniversity();
        Gender gender = personGenerator.getGender();
        String country = personGenerator.getCountry();


        return new TeamManager.Builder(name,surname,mail,country,size)
                .gender(gender).university(university).buildEmployee();
    }

    public Role getManagersRole() {
        int a = rand.nextInt(2) + 1;
        if (a == 1) {
            return Role.TEAM_LEADER;
        } else
            return Role.DEVELOPMENT_MANAGER;
    }


    public Developer getDeveloper() {

        String name = personGenerator.getName();
        String surname = personGenerator.getSurname();
        String mail = name + surname + personGenerator.getMail();
        String university = personGenerator.getUniversity();
        Gender gender = personGenerator.getGender();
        String country = personGenerator.getCountry();

        return new Developer.Builder(name,surname,mail,country)
                .gender(gender).university(university).buildEmployee();

    }


    public Role getDevsRole() {
        int b = rand.nextInt(3) + 1;
        if (b == 1)
            return Role.DEVELOPER;
        if (b == 2)
            return Role.TESTER;
        else
            return Role.CONTIBUTOR;
    }

    public List<Manager> getManagers(int size, int amount) {
        List<Manager> managersList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            managersList.add(getManager(size));
        }
        return managersList;
    }

    public List<Developer> getDevelopers(int amount) {
        List<Developer> developerList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            developerList.add(getDeveloper());
        }
        return developerList;
    }
}