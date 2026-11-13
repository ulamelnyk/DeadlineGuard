import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private Task task;
    private LocalDateTime notifyAt;
    private String status;

    public Notification(Task task, LocalDateTime notifyAt) {
        this.task = task;
        this.notifyAt = notifyAt;
        this.status = "Pending";
    }

    public Task getTask() {
        return task;
    }

    public LocalDateTime getNotifyAt() {
        return notifyAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Reminder for " + task.getTitle() + " at " + notifyAt.format(formatter) + ". \nStatus: " + status;
    }
}