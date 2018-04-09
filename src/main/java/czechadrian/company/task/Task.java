package czechadrian.company.task;

public class Task {
    private final String taskContent;
    private final int unitsOfWork;

    public Task(String taskContent,int unitsOfWork) {
        this.taskContent = taskContent;
        this.unitsOfWork = unitsOfWork;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public int getUnitsOfWork() {
        return unitsOfWork;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskContent='" + taskContent + '\'' +
                ", unitsOfWork=" + unitsOfWork +
                '}';
    }

}
