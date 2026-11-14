import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private List<Notification> notifications = new ArrayList<>();

    public void createTask(String title, String description, LocalDateTime deadline, List<Integer> remindHoursBefore) {
        Task task = new Task(title, description, deadline);
        tasks.add(task);

        for (int hours : remindHoursBefore) {
            LocalDateTime notifyTime = deadline.minusHours(hours);
            notifications.add(new Notification(task, notifyTime));
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Notification> getAllNotifications() {
        return notifications;
    }

    public void checkDueNotifications() {
        LocalDateTime now = LocalDateTime.now();
        boolean found = false;

        for (Notification notification : notifications) {
            if (!notification.getNotifyAt().isAfter(now) && notification.getStatus().equals("PENDING")) {
                System.out.println("Sending email: Upcoming deadline for '" + notification.getTask().getTitle() + "'");
                notification.setStatus("SENT");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No due notifications at this moment.");
        }
    }
}