import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime deadline;

    public Task(String title, String description, LocalDateTime deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task: " + title + " | Deadline: " + deadline;
    }
}
