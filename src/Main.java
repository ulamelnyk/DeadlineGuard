import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        boolean running = true;

        while (running) {
            System.out.println("\n === DeadlineGuard Menu ===");
            System.out.println("1. Add new task");
            System.out.println("2. View all tasks");
            System.out.println("3. View all notifications");
            System.out.println("4. Check due notifications");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter task title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();

                        System.out.print("Enter deadline (yyyy-MM-dd HH:mm): ");
                        String deadlineInput = scanner.nextLine();
                        LocalDateTime deadline = LocalDateTime.parse(deadlineInput, formatter);

                        System.out.print("Enter reminder intervals in hours (e.g. 24, 1): ");
                        String intervalsInput = scanner.nextLine();
                        List<Integer> intervals = new ArrayList<>();
                        for (String part : intervalsInput.split(",")) {
                            intervals.add(Integer.parseInt(part.trim()));
                        }

                        taskService.createTask(title, description, deadline, intervals);
                        System.out.println("Task and reminders created successfully.");
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd HH:mm.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid reminder intervals. Enter numbers separated by commas.");
                    }
                    break;
                case "2":
                    if (taskService.getAllTasks().isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (Task task : taskService.getAllTasks()) {
                            System.out.println(task);
                        }
                    }
                    break;
                case "3":
                    if (taskService.getAllNotifications().isEmpty()) {
                        System.out.println("No notifications scheduled.");
                    } else {
                        for (Notification notification : taskService.getAllNotifications()) {
                            System.out.println(notification);
                        }
                    }
                    break;
                case "4":
                    taskService.checkDueNotifications();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting DeadlineGuard.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}