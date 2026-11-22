package com.deadlineguard.repository;

import com.deadlineguard.entity.Notification;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusAndNotifyAtLessThanEqual(String status, LocalDateTime now);
}