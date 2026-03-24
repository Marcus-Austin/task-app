package com.austin.task_track.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.austin.task_track.domain.entity.Task;

public interface TaskService {

    List<Task> listTasks(UUID taskListId);
    Task createTask(UUID taskListId, Task task);
    Optional<Task>getTask(UUID taskListId, UUID taskId);
    Task updatedTask(UUID taskListId, UUID taskId, Task task);
    void deleteTask(UUID taskListId, UUID taskId);
}
