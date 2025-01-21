import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Project implements Manageable {
    private String name;
    private List<Task> tasks;
    private String assignee;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
        this.assignee = null;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void assign(String assignee) {
        this.assignee = assignee;
        System.out.println("Проект \"" + name + "\" назначен на " + assignee);
    }

    @Override
    public void start() {
        System.out.println("Проект \"" + name + "\" начат");
        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.TODO) {
                task.setStatus(TaskStatus.IN_PROGRESS);
            }
        }
    }

    @Override
    public void complete() {
        System.out.println("Проект \"" + name + "\" завершен");
        for (Task task : tasks) {
            task.setStatus(TaskStatus.DONE);
        }
    }

    public void sortTasksByDueDate() {
        Collections.sort(tasks, Comparator.comparing(Task::getDueDate));
        System.out.println("Задачи отсортированы по сроку выполнения.");
    }

    public void printTasks() {
        System.out.println("Задачи проекта \"" + name + "\":");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}