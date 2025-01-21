import java.util.Date;

public class TaskManagementDemo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Project project1 = new Project("Веб-сайт");
        Project project2 = new Project("Мобильное приложение");

        project1.addTask(new Task("Дизайн главной страницы", "Создать макет главной страницы", new Date()));
        project1.addTask(new Task("Разработка бэкенда", "Реализовать API", new Date(System.currentTimeMillis() + 86400000)));

        project2.addTask(new Task("Прототип интерфейса", "Создать прототип UI в Figma", new Date()));
        project2.addTask(new Task("Интеграция с сервером", "Настроить взаимодействие с API", new Date(System.currentTimeMillis() + 172800000)));

        taskManager.addProject(project1);
        taskManager.addProject(project2);

        taskManager.printAllProjects();

        System.out.println("\nЗадачи проекта 'Веб-сайт':");
        project1.printTasks();

        System.out.println("\nСортировка задач по сроку выполнения:");
        project1.sortTasksByDueDate();
        project1.printTasks();

        System.out.println("\nНазначение и начало проекта:");
        project1.assign("Иван Иванов");
        project1.start();

        System.out.println("\nСтатистика по проектам:");
        taskManager.printProjectsStats();

        System.out.println("\nЗавершение проекта 'Веб-сайт':");
        project1.complete();

        System.out.println("\nОбновленная статистика по проектам:");
        taskManager.printProjectsStats();
    }
}