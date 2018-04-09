package czechadrian.company.employee;

import java.util.Random;

public class PersonGenerator {

    private final String[] names = {"Zosia","Zdzisia","Paulina","Maciek","Achacja", "Achacjusz", "Achacy", "Achilles",
            "Ada", "Adalbert", "Adalberta", "Adalgunda", "Adalruna", "Alruna"};

    private final String[] surnames = {"Gabrowski", "Gadowski", "Gajda", "Galewicz",
            "Galiński", "Gałczyński","Pioro","Onderka","Daniels","Kowalski", "Gałecki", "Gancarczyk", "Garbowski"};

    private final String[] mail = {"@gmail.com","@wp.pl","@onet.pl","@yahoo.com",
            "@halohalo.com","@agh.edu.com","@interia.pl"};

    private final String[] university = {"AGH","UJ","PK","PW","PWr","UW","UP"};
    private final String[] country = {"PL","USA","UK","JP"};

    private Random rand = new Random();

    public String getName() {
        return names[rand.nextInt(names.length)];
    }

    public String getSurname() {
        return surnames[rand.nextInt(surnames.length)];
    }

    public String getMail() {
        return mail[rand.nextInt(mail.length)];
    }
    public String getUniversity() {
        return university[rand.nextInt(university.length)];
    }

    public String getCountry() {
        return country[rand.nextInt(country.length)];
    }
    public Gender getGender() {
           if(rand.nextInt(1)==1)
               return Gender.FEMALE;
           else
               return Gender.MALE;
    }
    public Role getCEO() {
        return Role.CEO;
    }

    public final int amount = 0;
}