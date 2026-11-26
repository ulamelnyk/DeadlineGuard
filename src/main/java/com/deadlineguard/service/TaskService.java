package com.deadlineguard.service;

import com.deadlineguard.dto.CreateTaskRequest;
import com.deadlineguard.entity.Notification;
import com.deadlineguard.entity.Task;
import com.deadlineguard.repository.NotificationRepository;
import com.deadlineguard.repository.TaskRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final NotificationRepository notificationRepository;

    public TaskService(TaskRepository taskRepository, NotificationRepository notificationRepository) {
        this.taskRepository = taskRepository;
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public Task createTask(CreateTaskRequest request) {
        Task task = new Task(request.title(), request.description(), request.deadline());
        Task savedTask = taskRepository.save(task);

        for (Integer hours : request.remindHoursBefore()) {
            LocalDateTime notifyTime = request.deadline().minusHours(hours);
            notificationRepository.save(new Notification(savedTask, notifyTime));
        }

        return savedTask;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}