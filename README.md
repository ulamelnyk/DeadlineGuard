# DeadlineGuard

**DeadlineGuard** is a task and deadline tracking service with customizable reminder notifications.

Currently implemented as an interactive Core Java prototype with a dedicated service layer, and designed to evolve into a Spring Boot REST API with PostgreSQL storage and automated email reminders.

## Current Features
* **Interactive Console Menu:** Create tasks, view active tasks and scheduled reminders, and trigger due-notification checks via `Scanner` with input validation.
* **Service Layer Architecture (`TaskService`):** Separates business logic (scheduling reminders and checking due timestamps) from console I/O.
* **Customizable Reminder Intervals:** Schedule multiple reminders per task (e.g., 24 hours and 1 hour before the deadline).
* **Notification State Tracking:** Track reminder states (`PENDING` / `SENT`) and format timestamps cleanly using `java.time` (`LocalDateTime`, `DateTimeFormatter`).

## Project Structure
```text
src/
├── Main.java           # Entry point with interactive console menu and input handling
├── TaskService.java    # Service layer managing tasks, reminder scheduling, and due checks
├── Task.java           # Domain model representing a task and its deadline
└── Notification.java   # Domain model representing a scheduled reminder and its status
```

## How to Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/ulamelnyk/DeadlineGuard](https://github.com/ulamelnyk/DeadlineGuard)
   ```
2. Open the project in **IntelliJ IDEA** (or any Java IDE).
3. Run `Main.java` and follow the interactive menu prompts in the console.

## Roadmap
* Core domain models (`Task`, `Notification`), service layer (`TaskService`), and interactive CLI
* Spring Boot REST API (`POST /api/tasks`) with PostgreSQL, Hibernate/JPA, and Flyway
* Docker & Docker Compose setup for local PostgreSQL deployment
* Background job scheduler (`@Scheduled`) and HTML email delivery (`JavaMailSender`)
