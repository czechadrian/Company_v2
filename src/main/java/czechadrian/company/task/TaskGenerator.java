package czechadrian.company.task;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TaskGenerator {

    private final List<String> tasksNames;
    private final Random generator;

    public TaskGenerator() {
        this.generator = new Random();

        this.tasksNames = Arrays.asList("webserwis","androidApp","coffee","pizza","junits",
                "analyzing","refactoring","update App");
    }

    public Task addTask() {
        int num =  generator.nextInt(tasksNames.size());
        return new Task(tasksNames.get(num),num+1);
    }
}