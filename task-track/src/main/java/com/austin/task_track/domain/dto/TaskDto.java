package com.austin.task_track.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.austin.task_track.domain.entity.TaskPriority;
import com.austin.task_track.domain.entity.TaskStatus;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority,
    TaskStatus status
) {
}
