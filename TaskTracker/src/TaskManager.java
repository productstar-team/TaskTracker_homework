import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Project> projects;

    public TaskManager() {
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
        System.out.println("Проект \"" + project.getName() + "\" добавлен.");
    }

    public Project getProject(String name) {
        for (Project project : projects) {
            if (project.getName().equals(name)) {
                return project;
            }
        }
        return null;
    }

    public void printAllProjects() {
        System.out.println("Список всех проектов:");
        for (Project project : projects) {
            System.out.println(project.getName());
        }
    }

    public void printProjectsStats() {
        System.out.println("Статистика по проектам:");
        for (Project project : projects) {
            System.out.println("Проект: " + project.getName());
            System.out.println("Количество задач: " + project.getTasks().size());
            System.out.println("Статус: " + ProjectStats.getProjectStatus(project));
            System.out.println("--------------------");
        }
    }
}