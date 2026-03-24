package com.austin.task_track.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.austin.task_track.domain.entity.Task;

public interface TaskRepository extends JpaRepository<Task,UUID>{

    List<Task> findByTaskListId(UUID taskListId);
    Optional<Task>findByTaskListIdAndid(UUID taskListId,UUID id);
    void deleteByTaskListIdAndid(UUID taskListId,UUID id);
}
