package czechadrian.company.report;

import czechadrian.company.employee.*;

public interface Report {

    Integer getAmountOfWork();

    String getNameOfWorker();
    String getSurnameOfWorker();

    Role getRole();


}