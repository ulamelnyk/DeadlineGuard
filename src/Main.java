import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();

        LocalDateTime deadline = LocalDateTime.now().plusHours(2);
        taskService.createTask(
                "Finish project",
                "Present project",
                deadline,
                List.of(24, 1)
        );

        System.out.println("Scheduled notifications:");
        for (Notification notification : taskService.getAllNotifications()) {
            System.out.println(notification);
        }

        System.out.println("\nChecking pending notifications:");
        taskService.checkDueNotifications();
    }
}