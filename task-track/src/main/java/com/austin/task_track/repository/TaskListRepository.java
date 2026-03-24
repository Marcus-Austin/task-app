package com.austin.task_track.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.austin.task_track.domain.entity.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, UUID>{

}
