package com.deadlineguard.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record CreateTaskRequest(
        @NotBlank String title,
        String description,
        @NotNull @Future LocalDateTime deadline,
        @NotEmpty List<Integer> remindHoursBefore
) {
}