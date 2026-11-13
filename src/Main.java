import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        List<Notification> notifications = new ArrayList<>();

        LocalDateTime deadline = LocalDateTime.now().plusHours(2);
        Task projectTask = new Task(
                "Finish project",
                "Present the project.",
                deadline
        );
        tasks.add(projectTask);

        int[] remindHoursBefore = {24, 1};
        for (int hours : remindHoursBefore) {
            LocalDateTime notifyTime = projectTask.getDeadline().minusHours(hours);
            notifications.add(new Notification(projectTask, notifyTime));
        }

        System.out.println("Scheduled notifications:");
        for (Notification notification : notifications) {
            System.out.println(notification);
        }

        System.out.println("Checking pending notifications:");
        LocalDateTime now = LocalDateTime.now();
        for (Notification notification : notifications) {
            if (!notification.getNotifyAt().isAfter(now) && notification.getStatus().equals("Pending")) {
                System.out.println("Sending email: Upcoming deadline for " + notification.getTask().getTitle() + ".");
                notification.setStatus("Sent");
            }
        }

        System.out.println("Updated notification statuses:");
        for (Notification notification : notifications) {
            System.out.println(notification);
        }
    }
}
