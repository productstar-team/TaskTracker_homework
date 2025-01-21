public class ProjectStats {
    public static String getProjectStatus(Project project) {
        int totalTasks = project.getTasks().size();
        int completedTasks = 0;

        for (Task task : project.getTasks()) {
            if (task.getStatus() == TaskStatus.DONE) {
                completedTasks++;
            }
        }

        if (completedTasks == 0) {
            return "Не начат";
        } else if (completedTasks == totalTasks) {
            return "Завершен";
        } else {
            return "В процессе (" + completedTasks + "/" + totalTasks + " задач выполнено)";
        }
    }
}