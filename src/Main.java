import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("DeadlineGuard Menu");
            System.out.println("1. Add new task");
            System.out.println("2. View all tasks");
            System.out.println("3. View all notifications");
            System.out.println("4. Check due notifications");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Task creation coming next...");
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