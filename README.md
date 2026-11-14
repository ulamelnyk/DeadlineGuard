# DeadlineGuard

**DeadlineGuard** is a task and deadline tracking service with customizable reminder notifications.

Currently implemented as a core Java prototype, with plans to add a Spring Boot REST API, PostgreSQL database storage, and automated email reminders.

## Current Features
* **Task Management:** Create tasks with a title, description, and target deadline (`LocalDateTime`).
* **Customizable Reminder Intervals:** Schedule multiple reminders per task (e.g., 24 hours and 1 hour before the deadline).
* **Notification Tracking:** Track reminder states (`PENDING` / `SENT`) and automatically detect due notifications.
* **Clean Date Formatting:** Human-readable timestamp formatting using `DateTimeFormatter`.

## Project Structure
```text
src/
├── Main.java           # Entry point demonstrating task creation and reminder checks
├── Task.java           # Domain model representing a task and its deadline
└── Notification.java   # Domain model representing a scheduled reminder and its status
```

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/ulamelnyk/DeadlineGuard
   ```
2. Open the project in **IntelliJ IDEA** (or any Java IDE).
3. Run `Main.java` to see scheduled notifications and due-time status updates in the console.
