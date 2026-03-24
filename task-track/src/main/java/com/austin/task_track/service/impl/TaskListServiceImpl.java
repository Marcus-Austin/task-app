package com.austin.task_track.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.austin.task_track.domain.entity.TaskList;
import com.austin.task_track.repository.TaskListRepository;
import com.austin.task_track.service.TaskListService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
       if(null != taskList.getId()){
        throw new IllegalArgumentException("Task List already has an id ");
       }
       if(null == taskList.getTitle() || taskList.getTitle().isBlank()){
        throw new IllegalArgumentException("Task List title must be present ");
       }

       LocalDateTime now = LocalDateTime.now();
       return  taskListRepository.save(new TaskList(
        null,
        taskList.getTitle(),
        taskList.getDescription(),
        null,
        now,
        now
       ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
      if(null == taskList.getId()){
        throw new IllegalArgumentException("Task List must have an id ");
       }   
       if(Objects.equals(taskList.getId(), taskListId)){
        throw new IllegalArgumentException("attempting to change task list Id, this is not permitted");
       }

       TaskList existingTaskList = taskListRepository.findById(taskListId)
       .orElseThrow(() -> new IllegalArgumentException("Task List not found"));

       existingTaskList.setTitle(taskList.getTitle());
       existingTaskList.setDescription(taskList.getDescription());
       existingTaskList.setUpdated(LocalDateTime.now());
       return taskListRepository.save(existingTaskList);
    }

    @Override
    public void deleteTaskList(UUID taskListId) {
        taskListRepository.deleteById(taskListId);
        
    }

    
}
